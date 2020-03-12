package com.automation.tests.day7;

import com.automation.pojos.Spartan;
import com.automation.pojos.Student;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import com.automation.pojos.Job;
import com.automation.pojos.Location;
import com.automation.utilities.ConfigurationReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class PreschoolTests {
    @BeforeAll
    public static void setup(){
        baseURI = ConfigurationReader.getProperty("school.uri");
    }

    @Test
    @DisplayName("Get student with id 2633 and convert payload into POJO")
    public void test1(){
        Response response = given().
                accept(ContentType.JSON).
                pathParam("id", 6846).
                when().
                get("/student/{id}").prettyPeek();
        //deserialization
        // from JSON to POJO
        //student - is a POJO
        Student student = response.jsonPath().getObject("students[0]", Student.class);

        System.out.println(student);

        assertEquals(6846, student.getStudentId());
        assertEquals(3, student.getBatch());
        assertEquals("125" ,student.getAdmissionNo());
        assertEquals("965 Nancy Center, Long Beach, CA 90847", student.getContact().getPermanentAddress());
        assertEquals("koteague0@shutterfly.com", student.getContact().getEmailAddress());


    }
}