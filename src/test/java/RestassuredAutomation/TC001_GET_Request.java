package RestassuredAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


import static org.codehaus.groovy.tools.shell.util.Logger.io;


public class TC001_GET_Request {


   @Test
    void getWeatherDetails(){

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Request object
        RequestSpecification httpRequest= RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/Hyderabad");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println(" >>> Response Body is : " + responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println(" >>> Status code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println(" >>> Status Line is:" + statusLine);
        Assert.assertEquals(statusLine  ," HTTP/1.1 200 OK");

    }

    /*
    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        get("/events?id=390").then().statusCode(200).assertThat()
                .body("data.leagueId", equalTo(35));
    }
*/


}
