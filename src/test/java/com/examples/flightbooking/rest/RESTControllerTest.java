package com.examples.flightbooking.rest;
import com.examples.flightbooking.rest.stubs.CustomerRepoStub;
import com.examples.flightbooking.rest.stubs.FlightRepoStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.net.*;

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

    public RESTControllerTest(){

    }

    // login
    @Before
    public void before() throws Exception {
        String result = "";
        CustomerRepoStub c_stub = new CustomerRepoStub();
        String fateme = c_stub.get_fateme();
        URL url = new URL ("http://localhost:8082/api/public/customer/login");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = fateme.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
        }

    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLogin() throws IOException {

        //TODO: Test goes here...
        String result = "";
        CustomerRepoStub c_stub = new CustomerRepoStub();
        String fateme = c_stub.get_fateme();
        URL url = new URL ("http://localhost:8082/api/public/customer/login");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = fateme.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
        }

        Assert.assertEquals(result, "true");

    }

    /**
    *
    * Method: getCustomers()
    *
    */
    @Test
    public void testGetCustomers() throws Exception {
    //TODO: Test goes here...
        String result = "";
        CustomerRepoStub c_stub = new CustomerRepoStub();
        URL url = new URL ("http://localhost:8082/api/public/customers");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
        }
        String expected = c_stub.get_all_customers();
        Assert.assertEquals(result, expected);
    }


    /**
    *
    * Method: getFlights()
    *
    */
    @Test
    public void testGetFlights() throws Exception {
    //TODO: Test goes here...
        String result = "";
        FlightRepoStub f_stub = new FlightRepoStub();

        URL url = new URL ("http://localhost:8082/api/public/flights");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
        }
        String expected = f_stub.get_all_flights();
        System.out.println(result);
        Assert.assertEquals(result, expected);
    }

    /**
    *
    * Method: getFlightsByCity(@PathVariable Integer sourceId, @PathVariable Integer destinationId)
    *
    */
    @Test
    public void testGetFlightsByCity() throws Exception {
    //TODO: Test goes here...

//        Mockito.when(flightService.getFlightsByCity(Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockFlightsByCity);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "http://localhost:8082/api/public/flights/source/1/destination/1").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        System.out.println(result.getResponse().getContentAsString().toString());
//        Assert.assertEquals(result.getResponse().getStatus(), 200);

        String result = "";
        FlightRepoStub f_stub = new FlightRepoStub();
        URL url = new URL ("http://localhost:8082/api/public/flights/source/1/destination/1");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
        }
        System.out.println(result);
        String expected = f_stub.get_flight_by_city();
        Assert.assertEquals(result, expected);
    }
}

