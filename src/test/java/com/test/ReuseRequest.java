package com.test;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReuseRequest
{
    RequestSpecification request;
    @BeforeClass
    public void beforeClass()
    {
        request = given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");
    }
    @Test
    public void statusCodeCheck() {

        given().spec(request).

                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().statusCode(200);
    }
    public void responseBodyCheck()
    {
        given().spec(request).

                when().
                get("/workspaces").

                then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces[0].name",equalTo("My Workspace")
                );

    }

}
