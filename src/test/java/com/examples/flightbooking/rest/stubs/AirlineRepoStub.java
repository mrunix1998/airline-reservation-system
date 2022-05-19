package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Airline;
import com.examples.flightbooking.repos.AirlineRepository;

import java.util.Optional;

public class AirlineRepoStub implements AirlineRepository {
    @Override
    public Airline findByAirlineNameIgnoreCase(String airlineName) {
        return null;
    }

    @Override
    public <S extends Airline> S save(S s) {
        return null;
    }

    @Override
    public <S extends Airline> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Airline> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Airline> findAll() {
        return null;
    }

    @Override
    public Iterable<Airline> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Airline airline) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airline> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
