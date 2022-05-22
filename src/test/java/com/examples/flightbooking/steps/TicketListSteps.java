package com.examples.flightbooking.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TicketListSteps {

    boolean isSignedIn = false;
    Response response;
    Integer userId = -1;

    @Given("^the \"([^\"]*)\" is signed in with \"([^\"]*)\" and \"([^\"]*)\" parameters to see ticket$")
    public void theIsSignedInWithAndParameters(String name, String email, String password) throws Throwable {

        Map<String, Object> request_body = new HashMap<>();
        request_body.put("email", email);
        request_body.put("password", password);
        response = given().contentType("application/json").body(request_body).
                post("http://localhost:8082/api/public/customer/login");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(String.format("TestCase status code: %s", response.statusCode()));


        response = given().contentType("application/json").get("http://localhost:8082/api/public/customers");
        //convert JSON to string
        JsonPath j = new JsonPath(response.asString());
        //get values of JSON array after getting array size
        List<Integer> ids = j.getList("customerId");
        List<String> names = j.getList("firstName");
        List<String> emails = j.getList("email");
        List<String> passwords = j.getList("password");
        for (int i = 0; i< names.size(); i++){
            if(names.get(i).equals(name) && emails.get(i).equals(email) && passwords.get(i).equals(password)){
                System.out.println("user is signed in !");
                isSignedIn = true;
                userId = ids.get(i);
                break;
            }
        }

        if(isSignedIn==false) {
            System.out.println("user is not signed in !");
        }
    }

    @When("^the user asks \"([^\"]*)\" metrics from flights table$")
    public void theUserAsksMetricsFromFlightsTable(String flightId) throws Throwable {
        if(isSignedIn){

            try {
                response = given().contentType(ContentType.JSON).
                        get(String.format("http://localhost:8082/api/public/flight/%s", flightId));
                response.prettyPrint();
                assert true;
            }
            catch (Exception e){
                assert false;
            }


        }
        else{
            System.out.println("Authorization Faild!");
        }
    }

    @Then("^the user sees the desired flights with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserSeesTheDesiredFlightsWithAndAnd(Integer sourceId, Integer destinationId, String date) throws Throwable {

        if(isSignedIn){

            String sId = Integer.toString(sourceId);
            String dId = Integer.toString(destinationId);
            response = given().contentType(ContentType.JSON).
                    get(String.format("http://localhost:8082/api/public/flights/source/%s/destination/%s", sId, dId));


            JsonPath j = new JsonPath(response.asString());
            List<Integer> flightIds = j.getList("flightId");
            List<String> flightCodes = j.getList("source.departureDateTime");
            List<String> dates = j.getList("source.departureDateTime");
            List<String> sourceAirPorts = j.getList("source.airport.airportName");
            List<String> destAirPorts = j.getList("destination.airport.airportName");
            List<Float> fare = j.getList("fare");
            List<Integer> capacity = j.getList("capacity");
            List<String> stats = j.getList("status");


            JSONArray array = new JSONArray();
            for (int i = 0; i< dates.size(); i++){
                if(dates.get(i).split(" ")[0].equals(date)){
                    JSONObject item = new JSONObject();
                    item.put("flightId", flightIds.get(i));
                    item.put("flightCode", flightCodes.get(i));
                    item.put("departureDate", dates.get(i));
                    item.put("sourceAirPort", sourceAirPorts.get(i));
                    item.put("destAirPort", destAirPorts.get(i));
                    item.put("capacity", capacity.get(i));
                    item.put("status", stats.get(i));
                    item.put("fare", fare.get(i));

                    array.put(item);
                }
            }
            for(int i = 0 ; i<array.length() ; i++){
                System.out.println(array.getJSONObject(i));

            }
        }

        else{
            System.out.println("Authorization Faild!");
        }

    }

}
