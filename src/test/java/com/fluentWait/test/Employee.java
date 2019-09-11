package com.fluentWait.test;

import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Employee {

    @Test
    public void validateemployee(){
        given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().statusCode(200).log().all();
    }

}
