package com.examples.flightbooking.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyStepdefs {

    boolean isSignedIn = false;
    Response response;

    @Given("^the \"([^\"]*)\" is signed in with \"([^\"]*)\" and \"([^\"]*)\" parameters$")
    public void theIsSignedInWithAndParameters(String name, String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        String urlToRead = "http://localhost:8082/api/public/customers";
        response = given().contentType("application/json").get("http://localhost:8082/api/public/customers");

        //convert JSON to string
        JsonPath j = new JsonPath(response.asString());

        //get values of JSON array after getting array size
        List<String> names = j.getList("firstName");
        List<String> emails = j.getList("email");
        List<String> passwords = j.getList("password");
        boolean isSignedIn = false;
        for (int i = 0; i< names.size(); i++){
            if(names.get(i).equals(name) && emails.get(i).equals(email) && passwords.get(i).equals(password)){
                System.out.println("user is signed in !");
                isSignedIn = true;
                break;
            }
        }

        if(isSignedIn==false) {
            System.out.println("user is not signed in !");
        }

    }

    @When("^the user asks metrics from booking table$")
    public void theUserAsksMetricsFromBookingTable() {

    }

    @Then("^the user view details before confirmation with \"([^\"]*)\"$")
    public void theUserViewDetailsBeforeConfirmationWith(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
