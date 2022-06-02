package com.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Test
{
    @org.testng.annotations.Test
    public void TestFirst()
    {
        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").

        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().statusCode(200).
                body("workspaces.name", hasItems("My Workspace"),
                        "workspaces.name",contains("My Workspace","My Personal Project"),
                        "workspaces.type",hasItems("personal","personal"),
                        "workspaces.size()",equalTo(2),
                        "workspaces[0].name",is(equalTo("My Workspace")),
                        "workspaces.type",containsInAnyOrder("personal","personal"),
                        "workspaces[1].name",is(equalTo("My Personal Project")),
                        "workspaces[0]",hasKey("id"),
                        "workspaces[0]",hasValue("personal"),
                        "workspaces[0]",hasEntry("id","716baa94-2bd2-4a8c-8150-0a467d25644b")
                );
    }
}
