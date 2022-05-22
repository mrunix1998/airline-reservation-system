package com.examples.flightbooking.rest.stubs;

import com.examples.flightbooking.models.Customer;
import com.examples.flightbooking.repos.CustomerRepository;

import java.util.Optional;

public class CustomerRepoStub implements CustomerRepository {


    public String get_fateme() {
        String fateme = "{\"email\": \"fateme@email.com\", \"password\": \"1111\"}";
        return fateme;
    }

    public String get_all_customers() {
        String customer_list = new String("[{\"customerId\":1,\"firstName\":\"Fateme\",\"lastName\":\"Rezaeian\",\"email\":\"fateme@email.com\",\"password\":\"1111\"},{\"customerId\":2,\"firstName\":\"Mohammad\",\"lastName\":\"Salehi\",\"email\":\"h.mammad@email.com\",\"password\":\"1111\"},{\"customerId\":3,\"firstName\":\"Mahdi\",\"lastName\":\"Kaveh\",\"email\":\"kaveh@email.com\",\"password\":\"1111\"},{\"customerId\":4,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@email.com\",\"password\":\"1111\"},{\"customerId\":5,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane@email.com\",\"password\":\"1111\"}]");
        return customer_list;
    }

    @Override
    public Customer findByEmailIgnoreCase(String email) {
        return null;
    }
    String expected = new String("[{\"customerId\":1,\"firstName\":\"Fateme\",\"lastName\":\"Rezaeian\",\"email\":\"fateme@email.com\",\"password\":\"1111\"},{\"customerId\":2,\"firstName\":\"Mohammad\",\"lastName\":\"Salehi\",\"email\":\"h.mammad@email.com\",\"password\":\"1111\"},{\"customerId\":3,\"firstName\":\"Mahdi\",\"lastName\":\"Kaveh\",\"email\":\"kaveh@email.com\",\"password\":\"1111\"},{\"customerId\":4,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@email.com\",\"password\":\"1111\"},{\"customerId\":5,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane@email.com\",\"password\":\"1111\"}]");

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
