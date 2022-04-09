package com.examples.flightbooking.services;

import com.examples.flightbooking.errors.InvalidRequestException;
import com.examples.flightbooking.models.Customer;
import com.examples.flightbooking.models.Flight;
import com.examples.flightbooking.models.Source;
import com.examples.flightbooking.models.Status;
import com.examples.flightbooking.utils.Util;
import com.examples.flightbooking.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Set<Customer> getCustomers()
    {
        Set<Customer> customers = new LinkedHashSet<>();
        Iterable<Customer> customerIterable = customerRepository.findAll();
        if(customerIterable != null)
        {
            customerIterable.forEach(customer -> customers.add(customer));
            return customers;
        }
        return null;
    }

    public Customer getCustomerById(Integer customerId)
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
    }

    public Customer getCustomerByEmail(String email)
    {
        if(Util.validateEmail(email)) return customerRepository.findByEmailIgnoreCase(email);
        return null;
    }

    public Customer customerLogin(String email, String password)
    {
        if(Util.validateEmail(email)) return customerRepository.findByEmailIgnoreCase(email);
        return null;
    }

    public Customer signup(Map<String, Object> json) throws InvalidRequestException, NoSuchElementException
    {

        String first_name = "first_name";
        String last_name = "last_name";
        String email = "email";
        String password = "password";

        if(Util.verifyCustomer(json))
        {
            first_name = (String) json.get(Util.CUSTOMER_FIRSTNAME_JKEY);
            last_name = (String)json.get(Util.CUSTOMER_LASTNAME_JKEY);
            email = (String)json.get(Util.CUSTOMER_EMAIL_JKEY);
            password = (String)json.get(Util.CUSTOMER_PASS_JKEY);
            Customer new_customer = new Customer(first_name, last_name, email, password);
//            customerRepository.signup(first_name, last_name, email, password);
            customerRepository.save(new_customer);
            Customer getCustomer = getCustomerByEmail(email);


            return getCustomer;
        }
        return null;
    }

    public Boolean login(Map<String, Object> json) throws InvalidRequestException, NoSuchElementException
    {
        String email = "email";
        String password = "password";

        if(Util.verifyLogin(json)){
            email = (String)json.get(Util.CUSTOMER_EMAIL_JKEY);
            password = (String)json.get(Util.CUSTOMER_PASS_JKEY);
            Customer customer = getCustomerByEmail(email);
            if (customer != null){
                if(customer.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean deleteCustomerById(Integer customerId) throws IllegalArgumentException, NoSuchElementException
    {
        if(Util.validateNumber(customerId))
        {
            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if(!optionalCustomer.isPresent())
                throw new NoSuchElementException("Customer does not exists with id="+customerId);
            customerRepository.deleteCustomerByCustomerId(customerId);
            return true;
        }
        return false;
    }
}
