package com.examples.flightbooking.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\ARSHAD\\TERM 2\\softwareTesting\\m git\\airline-reservation-system\\src\\test\\java\\com\\examples\\flightbooking\\feature",
        plugin = { "pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class TestRunner {


}
