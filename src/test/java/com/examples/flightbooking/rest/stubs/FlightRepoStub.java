package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Flight;
import com.examples.flightbooking.models.Status;
import com.examples.flightbooking.repos.FlightRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public class FlightRepoStub implements FlightRepository {
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
