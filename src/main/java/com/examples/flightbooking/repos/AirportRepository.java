package com.examples.flightbooking.repos;

import com.examples.flightbooking.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Integer>
{
    Airport findByAirportNameIgnoreCase(String airportName);
}
