

package com.automation.tests.day3;

import com.automation.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class ORDSTestsDay3 {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("ords.uri");
    }

    //accept("application/json") shortcut for header("Accept", "application/json")
    //we are asking for json as a response
    @Test
    public void test1() {
        given().
                accept("application/json").
                get("/employees").
                then().
                assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                log().all(true);
    }

    //path parameter - to point on specific resource /employee/:id/ - id it's a path parameter
    //query parameter - to filter results, or describe new resource :
    // POST /users?name=James&age=60&job-title=SDET
    //or to filter GET /employee?name=Jamal get all employees with name Jamal
    @Test
    public void test2() {
        given().
                accept("application/json").
                pathParam("id", 100).
                when().get("/employees/{id}").
                then().assertThat().statusCode(200).
                and().assertThat().body("employee_id", is(100),
                "department_id", is(90),
                "last_name", is("King")).
                log().all(true);
        //body ("phone_number") --> 515.123.4567
        //is is coming from ---> import static org.hamcrest.Matchers.*;
        //log().all  Logs everything in the response, including e.g. headers,
        // cookies, body with the option to pretty-print the body if the content-type is
    }

    /**
     * given path parameter is "/regions/{id}"
     * when user makes get request
     * and region id is equals to 1
     * then assert that status code is 200
     * and assert that region name is Europe
     */

    @Test
    public void test3() {
        given().
                accept("application/json").
                pathParam("id", 1).
                when().
                get("/regions/{id}").
                then().
                assertThat().statusCode(200).
                assertThat().body("region_name", is("Europe")).
                time(lessThan(10L), TimeUnit.SECONDS).
                log().body(true);//log body in pretty format. all = header + body + status code

        //verify that response time is less than 10 seconds
    }

    @Test
    public void test4() {
        JsonPath json = given().
                accept("application/json").
                when().
                get("/employees").
                thenReturn().jsonPath();

        //items[employee1, employee2, employee3] | items[0] = employee1.first_name = Steven

        String nameOfFirstEmployee = json.getString("items[0].first_name");
        System.out.println("First employee name: "+nameOfFirstEmployee);
    }
}