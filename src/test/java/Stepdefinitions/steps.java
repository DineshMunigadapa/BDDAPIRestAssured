package Stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import pojo.Location;
import pojo.addplace;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class steps extends Utils {
	ResponseSpecification resspec;
	RequestSpecification rs;
	Response response;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
				
				
				
		rs=given().spec(requestSpecification())
				.body(data.addPlacePayLoad(name,language,address));
	    
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		ApiResources resourceapi=ApiResources.valueOf(resource);
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
if(method.equalsIgnoreCase("POST"))
		response=rs.when().post(resourceapi.getResource())
				.then().spec(resspec).extract().response();
else if(method.equalsIgnoreCase("GET"))
	response=rs.when().get(resourceapi.getResource())
			.then().spec(resspec).extract().response();
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	    	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		String responsestring=response.asString();
		System.out.println(responsestring);
		JsonPath js=new JsonPath(responsestring);
		assertEquals(js.get(key).toString(), value);
	}

}
