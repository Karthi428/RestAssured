package com.test;

import io.restassured.config.LogConfig;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.*;

public class LogAll {
    @org.testng.annotations.Test
    public void TestFirst() {
        Set<String> headers = new HashSet<String>();
        headers.add("x-api-key");
        headers.add("Accept");

        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").
                //config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
                config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).
                log().all().
                when().
                get("/workspaces").

                then().
                log().body().
                assertThat().statusCode(200);
    }
}
