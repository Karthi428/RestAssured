import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ResponseSpecificationBuilder
{
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void beforeClass()
    {
       /* request = given().
                baseUri("https://api.getpostman.com").
                header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");*/
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.addHeader("x-api-key","PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2");

        requestSpecification = requestSpecBuilder.build();


       /* responseSpecification = RestAssured.expect().
                statusCode(200).
                contentType(ContentType.JSON).
                body("workspaces[0].name", is(equalTo("My Workspace")));*/

        //Response Specification Builder

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                expectBody("workspaces[0].name", is(equalTo("My Workspace"))).
                log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }
    @org.testng.annotations.Test
    public void statusCodeCheck()
    {
        given().spec(requestSpecification).get("/workspaces").
                then().spec(responseSpecification).
                log().all();
    }
    @Test
    public void responseBodyCheck()
    {

        Response response = given().spec(requestSpecification).get("/workspaces").
                then().spec(responseSpecification).
                log().all().extract().response();

    }
}
