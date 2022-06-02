package com.test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HandleHeaders
{
    @org.testng.annotations.Test
    public void TestFirst()
    {
        given().
                baseUri("https://13e2268a-c047-40c3-86c1-ac79e9b91ef2.mock.pstmn.io").
                header("header", "value1").

                when().
                get("/get").

                then().
                log().all().
                assertThat().statusCode(200).
                header("Content-Type","application/json; charset=utf-8");
    }
}
