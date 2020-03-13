package com.automation.tests.day9;

import com.automation.pojos.Spartan;
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

public class WarmUP {


    /**
     *  ####### WARM-UP TASK ########
     * Given accept content type as JSON
     * And query parameter api_key with valid API key
     * When user sends GET request to "/countries"
     * Then user verifies that total number of holidays in United Kingdom is equals to 95
     *
     * website: https://calendarific.com/
     *
     *
     *
     */

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("calendarific.uri");
    }



    @Test
    @DisplayName("user verifies that total number of holidays in United Kingdom is equals to 95")
    public void TC1() {
    }
    }