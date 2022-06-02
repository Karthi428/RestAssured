package com.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class QuerySpecification
{
    RequestSpecification requestSpecification;
    @BeforeClass
    public void beforeClass()
    {
       /* request = given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");*/
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.addHeader("x-api-key","PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");

        RestAssured.requestSpecification = requestSpecBuilder.build();
        
    }
    @Test
    public void querySpecification()
    {
        QueryableRequestSpecification querySpecification = SpecificationQuerier.
                query(RestAssured.requestSpecification);
        System.out.println(querySpecification.getBaseUri());
        System.out.println(querySpecification.getHeaders());

    }
    @Test
    public void statusCodeCheck()
    {
        Response response = get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
    }
    @Test
    public void responseBodyCheck()
    {

        Response response = get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
        assertThat(response.path("workspaces[0].name").toString(), equalTo("My Workspace"));

    }
}
