package com.examples.flightbooking.repos;

import com.examples.flightbooking.models.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
    Customer findByEmailIgnoreCase(String email);

    @Modifying
    @Transactional
    @Query(value = "delete from customers_flights cf where cf.customer_id = :c_id ; " +
                    "delete from reservations r where r.customer_id = :c_id ; " +
                    "delete from customers where customer_id = :c_id", nativeQuery = true)
    void deleteCustomerByCustomerId(@Param("c_id") Integer customerId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers c1 (first_name,last_name,email,password) " +
                   "VALUES (:first_name, :last_name, :email, :password);", nativeQuery = true)
    void signup(@Param("first_name") String first_name, @Param("last_name") String last_name,
                @Param("email") String email, @Param("password") String password);
}
