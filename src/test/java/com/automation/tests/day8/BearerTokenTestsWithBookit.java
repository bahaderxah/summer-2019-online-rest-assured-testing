
package com.automation.tests.day8;
import org.junit.jupiter.api.BeforeAll;

import com.automation.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTestsWithBookit {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("bookit.qa1");
    }

    //Let's get list of all rooms and verify that status code is 200
    // /api/rooms
    @Test
    @DisplayName("Get list of rooms")
    public void test1(){
        Response response = given().
                header("Authorization", getToken()).
                when().
                get("/api/rooms").prettyPeek();
    }

    /**
     * Method that generates access token
     * @return bearer token
     */
    public String getToken(){
        //https://cybertek-reservation-api-qa.herokuapp.com/sign?email=vasyl@cybertekschool.com&password=cybertek2020
        Response response = given().
                queryParam("email", ConfigurationReader.getProperty("team.leader.email")).
                queryParam("password", ConfigurationReader.getProperty("team.leader.password")).
                when().
                get("/sign").prettyPeek();
        return  response.jsonPath().getString("accessToken");
    }

}