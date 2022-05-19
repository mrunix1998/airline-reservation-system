package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Customer;
import com.examples.flightbooking.repos.CustomerRepository;

import java.util.Optional;

public class CustomerRepoStub implements CustomerRepository {

    @Override
    public Customer findByEmailIgnoreCase(String email) {
        return null;
    }

    @Override
    public void deleteCustomerByCustomerId(Integer customerId) {

    }

    @Override
    public void signup(String first_name, String last_name, String email, String password) {

    }

    @Override
    public <S extends Customer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Customer customer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
