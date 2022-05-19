package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Airplane;
import com.examples.flightbooking.repos.AirplaneRepository;

import java.util.Optional;

public class AirplaneRepoStub implements AirplaneRepository {
    @Override
    public <S extends Airplane> S save(S s) {
        return null;
    }

    @Override
    public <S extends Airplane> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Airplane> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Airplane> findAll() {
        return null;
    }

    @Override
    public Iterable<Airplane> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Airplane airplane) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airplane> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
