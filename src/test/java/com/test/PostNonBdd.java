package com.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class PostNonBdd
{
    @BeforeClass
    public void beforeClass()
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.getpostman.com").
                addHeader("x-api-key","PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
                RestAssured.requestSpecification = requestSpecBuilder.build();
//
//        //Response Specification Builder
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
//                expectStatusCode(200).
//                expectContentType(ContentType.JSON).
//                log(LogDetail.ALL);
//        //Default Response Specification
//        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void validate_post_request_non_bdd_style()
    {
        String payload = "{\n" +
                "    \"workspace\":{\n" +
                "    \"name\":\"myfirstWorkspace\",\n" +
                "    \"type\":\"personal\",\n" +
                "    \"description\":\"Rest Assured created this\"\n" +
                "    }\n" +
                "}";
        Response response =with().
                body(payload).
                post("/workspaces");
        assertThat(response.path("workspace.name"), equalTo("myfirstWorkspace"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));



    }
}
