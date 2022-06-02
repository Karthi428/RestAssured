package com.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BddNonBdd
{
    RequestSpecification request;
    @BeforeClass
    public void beforeClass()
    {
        request = with().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");
    }
    @Test
    public void statusCodeCheck() {
        Response response = request.get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
    }
    public void responseBodyCheck()
    {
        Response response = request.get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
        assertThat(response.path("workspaces[0].name").toString(),equalTo("My Workspace"));

    }
}
