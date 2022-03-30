package com.examples.flightbooking.rest;
import com.examples.flightbooking.models.*;
import com.examples.flightbooking.services.CustomerService;
import com.examples.flightbooking.services.FlightService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

/** 
* RESTController Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 30, 2022</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @MockBean
    FlightService flightService;

    Set<Customer> mockCustomers = new LinkedHashSet<>();
    Set<Flight> mockFlights = new LinkedHashSet<>();


    Customer c1 = new Customer(1,"Fateme", "Rezaeian", "fateme@email.com", "1111");
    Customer c2 = new Customer(2, "John", "Doe", "john@email.com", "1111");


    Flight f1 = new Flight(1, "4FF4", 4, 4, 13, 50.75F, 5, "ON_TIME");
    Flight f2 = new Flight(2,"1FF1", 1, 1, 1, 45.50F, 10, "ON_TIME");


    public RESTControllerTest(){
        mockCustomers.add(c1);
        mockCustomers.add(c2);

        mockFlights.add(f1);
        mockFlights.add(f2);
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }



    /**
    *
    * Method: getCustomers()
    *
    */
    @Test
    public void testGetCustomers() throws Exception {
    //TODO: Test goes here...

        Mockito.when(customerService.getCustomers()).thenReturn(mockCustomers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "http://localhost:8082/api/public/customers").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString().toString());
        Assert.assertEquals(result.getResponse().getStatus(), 200);

    }


    /**
    *
    * Method: getFlights()
    *
    */
    @Test
    public void testGetFlights() throws Exception {
    //TODO: Test goes here...
        Mockito.when(flightService.getFlights()).thenReturn(mockFlights);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "http://localhost:8082/api/public/flights").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString().toString());
        Assert.assertEquals(result.getResponse().getStatus(), 200);
    }

    /**
    *
    * Method: get(@PathVariable Integer flightId)
    *
    */
    @Test
    public void testGet() throws Exception {
    //TODO: Test goes here...
    }


    /**
    *
    * Method: getFlightsByDate(@PathVariable String date)
    *
    */
    @Test
    public void testGetFlightsByDate() throws Exception {
    //TODO: Test goes here...
    }


    /**
    *
    * Method: getFlightsByCity(@PathVariable Integer sourceId, @PathVariable Integer destinationId)
    *
    */
    @Test
    public void testGetFlightsByCity() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getAllRSVPsByCustomerId(@PathVariable Integer customerId)
    *
    */
    @Test
    public void testGetAllRSVPsByCustomerId() throws Exception {
    //TODO: Test goes here...
    }

} 
