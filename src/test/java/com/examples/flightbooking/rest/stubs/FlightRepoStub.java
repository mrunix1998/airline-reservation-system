package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Flight;
import com.examples.flightbooking.models.Status;
import com.examples.flightbooking.repos.FlightRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public class FlightRepoStub implements FlightRepository {


    public String get_all_flights() {
        String expected = new String("[{\"flightId\":1,\"flightCode\":\"1FF1\",\"source\":{\"sourceId\":1,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"destination\":{\"destinationId\":1,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"airplane\":{\"airplaneId\":1,\"airplaneName\":\"D107\",\"airline\":{\"airlineId\":1,\"airlineName\":\"IranAir\"}},\"availableSeat\":null,\"fare\":45.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":2,\"flightCode\":\"2FF2\",\"source\":{\"sourceId\":2,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"destination\":{\"destinationId\":2,\"arrivalDateTime\":\"01-15-2021 13:35:56\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"airplane\":{\"airplaneId\":5,\"airplaneName\":\"J130\",\"airline\":{\"airlineId\":2,\"airlineName\":\"KishAir\"}},\"availableSeat\":null,\"fare\":50.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":3,\"flightCode\":\"3FF3\",\"source\":{\"sourceId\":3,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"destination\":{\"destinationId\":3,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"airplane\":{\"airplaneId\":9,\"airplaneName\":\"S133\",\"airline\":{\"airlineId\":3,\"airlineName\":\"Pars\"}},\"availableSeat\":null,\"fare\":45.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":4,\"flightCode\":\"4FF4\",\"source\":{\"sourceId\":4,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"destination\":{\"destinationId\":4,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"airplane\":{\"airplaneId\":13,\"airplaneName\":\"U135\",\"airline\":{\"airlineId\":4,\"airlineName\":\"Aseman\"}},\"availableSeat\":null,\"fare\":50.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":5,\"flightCode\":\"5FF5\",\"source\":{\"sourceId\":5,\"departureDateTime\":\"01-15-2022 11:30:34\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"destination\":{\"destinationId\":5,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"airplane\":{\"airplaneId\":2,\"airplaneName\":\"D235\",\"airline\":{\"airlineId\":1,\"airlineName\":\"IranAir\"}},\"availableSeat\":null,\"fare\":55.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":6,\"flightCode\":\"6FF6\",\"source\":{\"sourceId\":6,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"destination\":{\"destinationId\":6,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"airplane\":{\"airplaneId\":6,\"airplaneName\":\"J238\",\"airline\":{\"airlineId\":2,\"airlineName\":\"KishAir\"}},\"availableSeat\":null,\"fare\":57.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":7,\"flightCode\":\"7FF7\",\"source\":{\"sourceId\":7,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"destination\":{\"destinationId\":7,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"airplane\":{\"airplaneId\":10,\"airplaneName\":\"S236\",\"airline\":{\"airlineId\":3,\"airlineName\":\"Pars\"}},\"availableSeat\":null,\"fare\":58.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":8,\"flightCode\":\"8FF8\",\"source\":{\"sourceId\":8,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"destination\":{\"destinationId\":8,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"airplane\":{\"airplaneId\":14,\"airplaneName\":\"U238\",\"airline\":{\"airlineId\":4,\"airlineName\":\"Aseman\"}},\"availableSeat\":null,\"fare\":54.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":9,\"flightCode\":\"9FF9\",\"source\":{\"sourceId\":9,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"destination\":{\"destinationId\":9,\"arrivalDateTime\":\"01-14-2022 13:35:56\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"airplane\":{\"airplaneId\":3,\"airplaneName\":\"D380\",\"airline\":{\"airlineId\":1,\"airlineName\":\"IranAir\"}},\"availableSeat\":null,\"fare\":68.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":10,\"flightCode\":\"10FF\",\"source\":{\"sourceId\":10,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"destination\":{\"destinationId\":10,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"airplane\":{\"airplaneId\":7,\"airplaneName\":\"J395\",\"airline\":{\"airlineId\":2,\"airlineName\":\"KishAir\"}},\"availableSeat\":null,\"fare\":69.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":11,\"flightCode\":\"11FF\",\"source\":{\"sourceId\":11,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"destination\":{\"destinationId\":11,\"arrivalDateTime\":\"01-14-2022 13:35:56\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"airplane\":{\"airplaneId\":11,\"airplaneName\":\"S390\",\"airline\":{\"airlineId\":3,\"airlineName\":\"Pars\"}},\"availableSeat\":null,\"fare\":67.5,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":12,\"flightCode\":\"12FF\",\"source\":{\"sourceId\":12,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"destination\":{\"destinationId\":12,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"airplane\":{\"airplaneId\":15,\"airplaneName\":\"U387\",\"airline\":{\"airlineId\":4,\"airlineName\":\"Aseman\"}},\"availableSeat\":null,\"fare\":68.75,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":13,\"flightCode\":\"13FF\",\"source\":{\"sourceId\":13,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"destination\":{\"destinationId\":13,\"arrivalDateTime\":\"01-14-2022 13:35:56\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"airplane\":{\"airplaneId\":4,\"airplaneName\":\"D710\",\"airline\":{\"airlineId\":1,\"airlineName\":\"IranAir\"}},\"availableSeat\":null,\"fare\":90.0,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":14,\"flightCode\":\"14FF\",\"source\":{\"sourceId\":14,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"destination\":{\"destinationId\":14,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"airplane\":{\"airplaneId\":8,\"airplaneName\":\"J725\",\"airline\":{\"airlineId\":2,\"airlineName\":\"KishAir\"}},\"availableSeat\":null,\"fare\":94.25,\"capacity\":5,\"status\":\"ON_TIME\"},{\"flightId\":15,\"flightCode\":\"15FF\",\"source\":{\"sourceId\":15,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":3,\"airportName\":\"USA\"}},\"destination\":{\"destinationId\":15,\"arrivalDateTime\":\"01-14-2022 13:35:56\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"airplane\":{\"airplaneId\":12,\"airplaneName\":\"S720\",\"airline\":{\"airlineId\":3,\"airlineName\":\"Pars\"}},\"availableSeat\":null,\"fare\":93.99,\"capacity\":10,\"status\":\"ON_TIME\"},{\"flightId\":16,\"flightCode\":\"16FF\",\"source\":{\"sourceId\":16,\"departureDateTime\":\"01-15-2022 09:30:34\",\"airport\":{\"airportId\":4,\"airportName\":\"UK\"}},\"destination\":{\"destinationId\":16,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"airplane\":{\"airplaneId\":16,\"airplaneName\":\"U718\",\"airline\":{\"airlineId\":4,\"airlineName\":\"Aseman\"}},\"availableSeat\":null,\"fare\":91.75,\"capacity\":5,\"status\":\"ON_TIME\"}]");
        return expected;
    }

    public String get_flight_by_city() {
        String expected = new String("[{\"flightId\":1,\"flightCode\":\"1FF1\",\"source\":{\"sourceId\":1,\"departureDateTime\":\"01-14-2022 11:30:34\",\"airport\":{\"airportId\":1,\"airportName\":\"Qom\"}},\"destination\":{\"destinationId\":1,\"arrivalDateTime\":\"01-15-2022 13:35:56\",\"airport\":{\"airportId\":2,\"airportName\":\"Tex\"}},\"airplane\":{\"airplaneId\":1,\"airplaneName\":\"D107\",\"airline\":{\"airlineId\":1,\"airlineName\":\"IranAir\"}},\"availableSeat\":null,\"fare\":45.5,\"capacity\":10,\"status\":\"ON_TIME\"}]");
        return expected;
    }


    @Override
    public Set<Flight> findByCurrentDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return null;
    }

    @Override
    public Set<Flight> findByDate(LocalDateTime dateTime) {
        return null;
    }

    @Override
    public Set<Flight> findFlightsByCity(Integer sourceId, Integer destinationId) {
        return null;
    }

    @Override
    public Set<Flight> findByFare(Float fare) {
        return null;
    }

    @Override
    public Set<Flight> findFlightsByStatus(Status status) {
        return null;
    }

    @Override
    public void deleteCustomersRSVPsByFlightId(Integer flightId, String flightStatus) {

    }

    @Override
    public void changeFlightStatus(String status, Integer flightId) {

    }

    @Override
    public <S extends Flight> S save(S s) {
        return null;
    }

    @Override
    public <S extends Flight> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Flight> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Flight> findAll() {
        return null;
    }

    @Override
    public Iterable<Flight> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Flight flight) {

    }

    @Override
    public void deleteAll(Iterable<? extends Flight> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
