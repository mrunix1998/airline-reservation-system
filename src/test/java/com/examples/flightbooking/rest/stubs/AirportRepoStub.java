package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Airport;
import com.examples.flightbooking.repos.AirportRepository;

import java.util.Optional;

public class AirportRepoStub implements AirportRepository {
    @Override
    public Airport findByAirportNameIgnoreCase(String airportName) {
        return null;
    }

    @Override
    public <S extends Airport> S save(S s) {
        return null;
    }

    @Override
    public <S extends Airport> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Airport> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Airport> findAll() {
        return null;
    }

    @Override
    public Iterable<Airport> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Airport airport) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airport> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
