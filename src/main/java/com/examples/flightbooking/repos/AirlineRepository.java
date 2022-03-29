package com.examples.flightbooking.repos;

import com.examples.flightbooking.models.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer>
{
    Airline findByAirlineNameIgnoreCase(String airlineName);
}
