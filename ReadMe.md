

REST Assured is a Java Domain Specific Language API for simplifying testing of RESTful web services. REST Assured API can be used to invoke REST web services and match response content to test them.
___________________________________________________________________

**REST Assured:**

REST Assured can be used to test XML as well as JSON based web services. REST Assured can be integrated with JUnit and TestNG frameworks for writing test cases for our application.

REST Assured supports POST, GET, PUT, DELETE, OPTIONS, PATCH, and HEAD requests and can be used to validate and verify the response of these requests.

REST Assured is implemented in Groovy and uses the builder pattern to create requests, set headers, parse the response and then match them with expected data. It uses Hamcrest Matchers for comparing actual response with the expected response.

One of the powerful features of REST assured is the support of XML Path and JSON Path syntax to check specific elements of the response data. It’s very similar to using XPath API.
______________
**Prerequisites:**

Java

IDE (Eclipse, IntelliJ, etc)

Maven

TestNG
___________________________________________________________________


**HTTP Methods:**
![enter image description here](https://sendeyo.com/updownload/file/script/413acb10a36bf698fa87eef885f3dd99.webp)
_____________________


**Steps to create Project in IntelliJ/Eclipse:**

Step 1: Open IntelliJ/Eclipse

Step 2: Create a maven project

Step 3: Add dependencies in pom.xml

Step 4: Save project

Step 5: Check libraries added
_______________________________________

**Maven Dependencies for testNG and Rest Assured which need to paste in POM.XML file**


    <dependencies> 
    <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured --> <dependency>  
      <groupId>io.rest-assured</groupId>  
      <artifactId>rest-assured</artifactId>  
      <version>5.1.0</version>  
      <scope>test</scope>  
    </dependency> 
    <!-- https://mvnrepository.com/artifact/org.testng/testng --> <dependency>  
      <groupId>org.testng</groupId>  
      <artifactId>testng</artifactId>  
      <version>7.6.0</version>  
      <scope>test</scope>  
      </dependency>  
      
    </dependencies>
 _________________
 

**Step to Run First Rest Assurance Test:**

Step 1: Create a class

Step 2: Create a function and annotate with @Test (TestNG)

Step 3: Run a GET request

Step 4: Store response and print response data

Step 5: Add assertions

Step 6: Run and verify
____________________


**Groovy Play Ground**

REST Assured uses Groovy under the hood. This means we can use the Groovy syntax when writing our code, and it gives us immense power. Groovy comes with a path expression language called GPath. It is this that is used to extract responses.

Where REST assured is used?

REST Assured is a java library used for **testing and validating the Restful Web Services**

[**https://groovyconsole.appspot.com/**](https://groovyconsole.appspot.com/)

    import groovy.json.JsonSlurper  
      
    def object = new JsonSlurper().parseText(  
    '''  
    {  
    "workspaces": [  
    {  
    "id": "716baa94-2bd2-4a8c-8150-0a467d25644b",  
    "name": "My Workspace",  
    "type": "personal"  
    },  
    {  
    "id": "952d7c49-f0c4-402f-9292-357ec4a9aa0f",  
    "name": "My Personal Project",  
    "type": "personal"  
    }  
    ]  
    }  
    '''  
      
    )  
    def query = object.workspaces[1].name

**Output:**![enter image description here](https://sendeyo.com/updownload/file/script/8832c8fc45101cb37949e88ab5484b0e.webp)

_________________________

**Method chaining method in Main method without using rest assured:**

    package methodchaining;  
      
    public class MethodChain { public static void main(String[] args) {  
      MethodChain md = new MethodChain(); md.a1().a2().a3(); } public MethodChain a1() {  
      System._out_.println("This is methodchain 1");  
      return this; } public MethodChain a2() {  
      System._out_.println("This is methodchain 2");  
      return this; } public MethodChain a3() {  
      System._out_.println("This is methodchain 3");  
      return this; }  
    }

**Automate GET Request – Assert Status Code:**

    package com.test;  
      
    import static io.restassured.RestAssured.*;  
    import static io.restassured.matcher.RestAssuredMatchers.*;  
    import static org.hamcrest.Matchers.*;  
    public class Test  
    {  
    @org.testng.annotations.Test  
    public void TestFirst()  
    {  
    _given_().  
    baseUri("https://api.getpostman.com").  
    header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").  
      
    when().  
    get("/workspaces").  
    then().  
    log().all().  
    assertThat().statusCode(200);  
    }  
    }

output:
![enter image description here](https://sendeyo.com/updownload/file/script/8302234b9e066aea63fb971d0110cefb.webp)
_____________________

**Automate GET Request - Assert Response body:**

    package com.test;  
      
    import static io.restassured.RestAssured.*;  
    import static io.restassured.matcher.RestAssuredMatchers.*;  
    import static org.hamcrest.Matchers.*;  
    public class Test  
    {  
    @org.testng.annotations.Test  
    public void TestFirst()  
    {  
    _given_().  
    baseUri("https://api.getpostman.com").  
    header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").  
      
    when().  
    get("/workspaces").  
    then().  
    log().all().  
    assertThat().statusCode(200).  
    body("workspaces.name", _hasItems_("My Workspace","My Personal Project"),  
    "workspaces.type",_hasItems_("personal","personal"),  
    "workspaces.size()",_equalTo_(2),  
    "workspaces[0].name",_is_(_equalTo_("My Workspace")),  
    "workspaces[1].name",_is_(_equalTo_("My Personal Project"))  
    );  
    }  
    }
_________________________________

**What is Hamcrest and Why it is popular?**
Hamcrest is a widely used framework for unit testing in the Java world.

Hamcrest target is to make your tests easier to write and read. For this, it provides additional matcher classes which can be used in test for example written with  JUnit. You can also define custom matcher implementations.

To use Hamcrest matchers in your test you use the  `assertThat`  statement followed by one or several matchers.

The following are the most important Hamcrest matchers:

-   `allOf`  - matches if all matchers match (short circuits)
    
-   `anyOf`  - matches if any matchers match (short circuits)
    
-   `not`  - matches if the wrapped matcher doesn’t match and vice
    
-   `equalTo`  - test object equality using the equals method
    
-   `is`  - decorator for equalTo to improve readability
    
-   `hasToString`  - test Object.toString
    
-   `instanceOf`,  `isCompatibleType`  - test type
    
-   `notNullValue`,  `nullValue`  - test for null
    
-   `sameInstance`  - test object identity
    
-   `hasEntry`,  `hasKey`,  `hasValue`  - test a map contains an entry, key or value
    
-   `hasItem`,  `hasItems`  - test a collection contains elements
    
-   `hasItemInArray`  - test an array contains an element
    
-   `hasProperty`  - checks if a Java Bean has a certain property can also check the value of this property
    
-   `closeTo`  - test floating point values are close to a given value
    
-   `greaterThan`,  `greaterThanOrEqualTo`,  `lessThan`,  `lessThanOrEqualTo`
    
-   `equalToIgnoringCase`  - test string equality ignoring case
    
-   `equalToIgnoringWhiteSpace`  - test string equality ignoring differences in runs of whitespace
    
-   `containsString`,  `endsWith`,  `startsWith`  - test string matching

___________________
<![endif]-->

**BlackList Header**

    config(_config_.logConfig(LogConfig._logConfig_().blacklistHeader("x-api-key")))

**it will black the header in console because Header is most sensible**

**Before adding BlacList Header**

    Request method:  GET
    Request URI:  https://api.getpostman.com/workspaces
    Proxy:  <none>
    Request params:  <none>
    Query params:  <none>
    Form params:  <none>
    Path params:  <none>
    Headers:  x-api-key=PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2
    Accept=*/*
    Cookies:  <none>
    Multiparts:  <none>
    Body:  <none>
    {
    "workspaces": [
    {
    "id": "716baa94-2bd2-4a8c-8150-0a467d25644b",
    "name": "My Workspace",
    "type": "personal"
    },
    {
    "id": "952d7c49-f0c4-402f-9292-357ec4a9aa0f",
    "name": "My Personal Project",
    "type": "personal"
    }
    ]
    }

**After Giving BlackList Header**


	

    Request method:  GET
        Request URI:  https://api.getpostman.com/workspaces
        Proxy:  <none>
        Request params:  <none>
        Query params:  <none>
        Form params:  <none>
        Path params:  <none>
        Headers: x-api-key=[ BLACKLISTED ]
    	Accept=*/*
        Cookies:  <none>
        Multiparts:  <none>
        Body:  <none>
        {
        "workspaces": [
        {
        "id": "716baa94-2bd2-4a8c-8150-0a467d25644b",
        "name": "My Workspace",
        "type": "personal"
        },
        {
        "id": "952d7c49-f0c4-402f-9292-357ec4a9aa0f",
        "name": "My Personal Project",
        "type": "personal"
        }
        ]
        }

**Multiple BlackList Headers**

    package com.test;  
      
    import io.restassured.config.LogConfig;  
    import io.restassured.response.Response;  
      
    import java.util.HashSet;  
    import java.util.Set;  
      
    import static io.restassured.RestAssured.*;  
      
    public class LogAll {  
    @org.testng.annotations.Test  
    public void TestFirst() {  
    Set<String> headers = new HashSet<String>();  
    headers.add("x-api-key");  
    headers.add("Accept");  
      
    _given_().  
    baseUri("https://api.getpostman.com").  
    header("x-api-key", "PMAK-629455a80ae54c00528072c7-824d4099b7ce5004d7a8096bfa4112b2e2").  
    //config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).  
    config(_config_.logConfig(LogConfig._logConfig_().blacklistHeaders(headers))).  
    log().all().  
    when().  
    get("/workspaces").  
      
    then().  
    log().body().  
    assertThat().statusCode(200);  
    }  
    }

