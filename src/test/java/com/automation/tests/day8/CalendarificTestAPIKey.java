package com.automation.tests.day8;

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

public class CalendarificTestAPIKey {
    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("calendarific.uri");
    }


/**
 * API key is a secret that the API generates and gives to the developer.
 * API key looks like long string: ebe88078e981c84bedeb9e8a34ad927560e545f2
 * API key can go as query parameter or inside a header,
 * it depends on web service how you must pass API key (as header parameter or query parameter)
 * How it get's created? You go to web site, register, and service gives you API key
 * Then you have to pass API key alongside with every request
 * API key is easy to implement for developer and client
 * But, non-technical people have no idea about this
 * So it's mostly used by developers only
 */

/**
 * Given accept content type as JSON
 * When user sends GET request to "/countries"
 * Then user verifies that status code is 401
 * And user verifies that status line contains "Unauthorized" message
 * And user verifies that meta.error_detail contains "Missing or invalid api credentials." message
 */


//status line: HTTP/1.1 401 Unauthorized