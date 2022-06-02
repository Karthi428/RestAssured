package com.test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ExtractResponse
{
    @org.testng.annotations.Test
    public void TestFirst()
    {
        Response res = given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").

                when().
                get("/workspaces").
                then().
                //log().all().
                assertThat().statusCode(200).
                extract().response();
        System.out.println("The response is    "+res.asString());
    }
}
