package com.examples.flightbooking.rest;

import com.examples.flightbooking.errors.InvalidRequestException;
import com.examples.flightbooking.errors.InvalidRequestExceptionResponse;
import com.examples.flightbooking.utils.Util;
import com.examples.flightbooking.models.Airline;
import com.examples.flightbooking.models.Airplane;
import com.examples.flightbooking.models.Airport;
import com.examples.flightbooking.models.Customer;
import com.examples.flightbooking.models.Flight;
import com.examples.flightbooking.models.Reservation;
import com.examples.flightbooking.services.AirlineService;
import com.examples.flightbooking.services.AirplaneService;
import com.examples.flightbooking.services.AirportService;
import com.examples.flightbooking.services.CustomerService;
import com.examples.flightbooking.services.FlightService;
import com.examples.flightbooking.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/public")
public class RESTController
{
    private final AirportService airportService;
    private final AirlineService airlineService;
    private final AirplaneService airplaneService;
    private final CustomerService customerService;
    private final FlightService flightService;
    private final ReservationService reservationService;
    private boolean isAuthorized = false;

    @Autowired
    public RESTController(final AirportService airportService, final AirlineService airlineService,
                          final AirplaneService airplaneService, final CustomerService customerService,
                          final FlightService flightService, final ReservationService reservationService)
    {
        this.airportService = airportService;
        this.airlineService = airlineService;
        this.airplaneService = airplaneService;
        this.customerService = customerService;
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/airports", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Airport>> getAirports() {
        if (isAuthorized) {
            List<Airport> airports = airportService.getAirports();
            return airports != null ? new ResponseEntity<>(airports, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/airport/{airportName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> getAirportByName(@PathVariable String airportName)
    {

        if (isAuthorized) {
            try {
                Airport airport = null;
                if (Util.validateAirportName(airportName)) {
                    airport = airportService.getAirportByName(airportName);
                }
                return airport != null ? new ResponseEntity<>(airport, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/airlines", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Airline>> getAirlines()
    {
        if (isAuthorized) {
            List<Airline> airlines = airlineService.getAirlines();
            return airlines != null ? new ResponseEntity<>(airlines, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/airline/{airlineName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airline> getAirlineByName(@PathVariable String airlineName)
    {
        if (isAuthorized) {
            try {
                Airline airline = null;
                if (Util.validateAirlineName(airlineName)) {
                    airline = airlineService.getAirlineByName(airlineName);
                }
                return airline != null ? new ResponseEntity<>(airline, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/airline/{airlineName}/airplanes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Airplane>> getAirplanesByAirlineName(@PathVariable String airlineName)
    {
        if (isAuthorized) {
            try {
                Set<Airplane> airplanes = null;
                if (Util.validateAirlineName(airlineName))
                    airplanes = airlineService.getAirplanesByAirlineName(airlineName);
                return airplanes != null ? new ResponseEntity<>(airplanes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/airplanes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Airplane>> getAirplanes()
    {
        if (isAuthorized) {
            List<Airplane> airplanes = airplaneService.getAirplanes();
            return airplanes != null ? new ResponseEntity<>(airplanes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Customer>> getCustomers()
    {
        Set<Customer> customers = customerService.getCustomers();
        return customers != null ? new ResponseEntity<>(customers, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/customer/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email)
    {
        if (isAuthorized) {
            Customer customer = customerService.getCustomerByEmail(email);
            return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/customer/login", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> login(@RequestBody Map<String, Object> json)
    {
        isAuthorized = false;
        Boolean login = customerService.login(json);
        if (login == true){
            isAuthorized = true;
            return new ResponseEntity<>(isAuthorized, HttpStatus.OK);
        }

        return new ResponseEntity<>(isAuthorized, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/customer/logout",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> logout()
    {
        isAuthorized = false;
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Flight>> getFlights()
    {
        if (isAuthorized) {

            Set<Flight> flights = flightService.getFlights();
            return flights != null ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flight/{flightId}")
    public ResponseEntity<Flight> get(@PathVariable Integer flightId)
    {
        if (isAuthorized) {
            try {
                Flight flight = null;
                if (Util.validateNumber(flightId)) flight = flightService.getFlightById(flightId);
                return flight != null ? new ResponseEntity<>(flight, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flights/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Flight>> getFlightsByToday()
    {
        if (isAuthorized) {
            Set<Flight> flights = flightService.getFlightsForToday();
            return flights != null ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flights/{date}")
    public ResponseEntity<Set<Flight>> getFlightsByDate(@PathVariable String date)
    {
        if (isAuthorized) {
            try {
                Set<Flight> flights = flightService.getFlightsByDate(Util.stringDateToDateTime(date));
                return flights != null ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flights/fare/{fare}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Flight>> getFlightsByFare(@PathVariable Float fare)
    {
        if (isAuthorized) {
            Set<Flight> flights = flightService.getFlightsByFare(fare);
            return flights != null && !flights.isEmpty() ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flights/status/{status}")
    public ResponseEntity<Set<Flight>> getFlightsByStatus(@PathVariable String status)
    {
        if (isAuthorized) {
            try {
                Set<Flight> flights = flightService.getFlightsByStats(status);
                return flights != null ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/flights/source/{sourceId}/destination/{destinationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Flight>> getFlightsByCity(@PathVariable Integer sourceId, @PathVariable Integer destinationId)
    {
        if (isAuthorized) {
            Set<Flight> flights = flightService.getFlightsByCity(sourceId, destinationId);
            return flights != null && !flights.isEmpty() ? new ResponseEntity<>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/rsvps/customer/{customerId}")
    public ResponseEntity<Set<Reservation>> getAllRSVPsByCustomerId(@PathVariable Integer customerId)
    {
        if (isAuthorized) {
            try {
                Set<Reservation> reservations = reservationService.getAllRSVPsByCustomerId(customerId);
                return reservations != null ? new ResponseEntity<>(reservations, HttpStatus.OK) :
                        new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/rsvps/cancelled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Reservation>> getAllCancelledRSVPs()
    {
        if (isAuthorized) {
            Set<Reservation> reservations = reservationService.getAllCancelledRSVPs();
            return reservations != null ? new ResponseEntity<>(reservations, HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/rsvps/{airline}/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Reservation>> getAllActiveRSVPsByAirline(@PathVariable String airline)
    {
        if (isAuthorized) {
            try {
                Set<Reservation> reservations = reservationService.getAllActiveRSVPsByAirline(airline);
                return reservations != null ? new ResponseEntity<>(reservations, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/rsvps/{airline}/cancelled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Reservation>> getAllCancelledRSVPsByAirline(@PathVariable String airline)
    {
        if (isAuthorized) {
            try {
                Set<Reservation> reservations = reservationService.getAllCancelledRSVPsByAirline(airline);
                return reservations != null ? new ResponseEntity<>(reservations, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> insertFlight(@RequestBody Flight flight)
    {
        if (isAuthorized) {
            try {
                return new ResponseEntity<>(flightService.addFlight(flight), HttpStatus.OK);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            } catch (NullPointerException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/rsvp/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addRSVPByCustomerId(@RequestBody Map<String, Object> json)
    {
        if (isAuthorized) {
            try {
                return reservationService.addRSVPByCustomerId(json) ? new ResponseEntity<>(true, HttpStatus.OK) :
                        new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            } catch (IllegalArgumentException ex) {
                InvalidRequestException response = new InvalidRequestException(HttpStatus.CHECKPOINT.value(), ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.CHECKPOINT);
            } catch (InvalidRequestException ex) {
                InvalidRequestExceptionResponse response = new InvalidRequestExceptionResponse(ex);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } catch (NoSuchElementException ex) {
                InvalidRequestExceptionResponse response = new InvalidRequestExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/airport", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        if (isAuthorized) {
            Airport addedAirport = airportService.addAirport(airport);
            return addedAirport != null ? new ResponseEntity<>(airport, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping(value = "/rsvp/cancel/{rsvpId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> cancelRSVPByCustomerId(@PathVariable Integer rsvpId)
    {
        if(isAuthorized)
        {
            try {
                boolean isCancelled = reservationService.cancelRSVPByCustomerId(rsvpId);
                return isCancelled ? new ResponseEntity<>(true, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping(value = "/flight/cancel/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> cancelFlightById(@PathVariable Integer flightId)
    {
        if(isAuthorized) {
            return flightService.cancelFlight(flightId) ? new ResponseEntity<>(true, HttpStatus.OK) : new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/customer/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> signup(@RequestBody Map<String, Object> json)
    {

        try
        {
            Customer customer = customerService.signup(json);
            return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (IllegalArgumentException ex)
        {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(value = "/delete/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Integer customerId)
    {
        if(isAuthorized) {
            try {
                return customerService.deleteCustomerById(customerId) ? new ResponseEntity<>(true, HttpStatus.OK) :
                        new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, ex.getMessage(), ex);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
