package com.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PutMethod
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

        //Response Specification Builder

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        //Default Response Specification
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void validate_post_request_bdd_style()
    {
        String payload = "{\n" +
                "    \"workspace\":{\n" +
                //Here "newWorkspacesName" is the new workspace name
                "    \"name\":\"newWorkspacesName\",\n" +
                "    \"type\":\"personal\",\n" +
                "    \"description\":\"Rest Assured created this\"\n" +
                "    }\n" +
                "}";
        given().
                body(payload).
                //You can send the workspace id through the Path Parameter
                pathParam("workspaceId","b977196c-e8ea-4ee2-b710-8de488b2debd").
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/workspaces/{workspaceId}").
                then().
                assertThat().
                body("workspace.name", equalTo("newWorkspacesName"),
                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));


    }
}
