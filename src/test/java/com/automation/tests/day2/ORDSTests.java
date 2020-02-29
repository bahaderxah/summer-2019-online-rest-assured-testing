package com.automation.tests.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class ORDSTests {
    //address of ORDS web service, that is running no AWS ec2.
    //data is coming from SQL Oracle data base to this web service
    //during back-end testing with SQL developer and JDBC API
    //we were accessing data base directly
    //now, we gonna access web service

    //according to OOP conventions, all instance variable should be private
    //but, if we will make it public, it will not make ant difference for us
    //it's just good practice, so later we will not hesitate which keyword to use when it's gonna important

    //ec2-34-201-69-55.compute-1.amazonaws.com - my host, you have something else
    //   /ords/hr or //ords/hr/employees - same for all

    private String baseURI = "http://ec2-52-70-55-252.compute-1.amazonaws.com:1000/ords/hr";
    private String employees;

    //we start from given()
    //then we can specify type of request like: get(), put(), delete(), post()
    //and as parameter, we enter resource location (URI)
    //then we are getting response back. that response we can put into Response object
    //from response object, we can retrieve: body, header, status code

    //it works without RestAssured.given() because of static import
    //verify that status code is 200
    @Test
    public void test1(){
        Response response = given()
          .get(baseURI+"/employees");
        System.out.println(response.getBody().asString());
        assertEquals(200,response.getStatusCode());

    }
}
