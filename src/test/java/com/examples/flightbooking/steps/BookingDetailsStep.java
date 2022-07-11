package com.examples.flightbooking.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static io.restassured.RestAssured.given;

public class BookingDetailsStep {


    boolean isSignedIn = false;
    Response response;
    Integer userId = -1;


    @Before
    public void beforeScenario(){
        System.out.println("brfore steps");
    }

    @After
    public void afterScenario(){
        System.out.println("after steps");
    }

    @Given("^the \"([^\"]*)\" is signed in with \"([^\"]*)\" and \"([^\"]*)\" parameters$")
    public void theIsSignedInWithAndParameters(String name, String email, String password) {

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

    @When("^the user asks metrics from booking table$")
    public void theUserAsksMetricsFromBookingTable() {

        if(isSignedIn){
            try {
                String uid = Integer.toString(userId);
                response = given().contentType(ContentType.JSON).
                        get(String.format("http://localhost:8082/api/public/rsvps/customer/%s", uid));
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

    @Then("^the user view details before confirmation with \"([^\"]*)\"$")
    public void theUserViewDetailsBeforeConfirmationWith(String inputDate) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(isSignedIn){
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            JsonPath j = new JsonPath(response.asString());

            List<Integer> reservationIds = j.getList("rsvpId");
            List<String> dates = j.getList("rsvpDate");
            List<String> stats = j.getList("status");

            JSONArray array = new JSONArray();

            for (int i = 0; i< dates.size(); i++){
                if((dates.get(i).split(" ")[0]).equals(inputDate)){
                    JSONObject item = new JSONObject();
                    item.put("reservationId", reservationIds.get(i));
                    item.put("reservationDate", dates.get(i));
                    item.put("status", stats.get(i));
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
