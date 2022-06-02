package com.test;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Request {
    @org.testng.annotations.Test
    public void TestFirst() {
        RequestSpecification resquest = given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");
        given().spec(resquest).

                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().statusCode(200);
    }
}
