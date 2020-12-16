package com.sanaca.restassured.methods;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestHttpMethods {
	
	private final String BaseUrl="http://dummy.restapiexample.com/api/v1";
	private final String GetEmployees ="/employees";
	private final String CreateEmployees ="/create";
	
	private RequestSpecification requestSpec;
	private ResponseSpecification responseSpec;
	
	private static ValidatableResponse vResponse;
	public static Response response;
	private static int statusCode;
	private static String responseHeader;
	private static int responseCount;
	
	public RestHttpMethods(){
		requestSpec = new RequestSpecBuilder().setBaseUri(BaseUrl).setAccept(ContentType.JSON).build();
		responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}

	public int returnStatusCode(){
		return statusCode;
	}
	
	public String returnResponseAsString(){
		return response.asString();
	}
	public String returnResponseHeaders(){
		return responseHeader;
	}
	
	public int lengthOfResponse(){
		return responseCount;
	}
	
	
	
	// POST /create response
	public void createEmployee(String name, String salary, int age){
		Employee employee = new Employee(name, salary, age);
		response = given().log().all().spec(requestSpec).contentType("application/json").body(employee).
				when().post(CreateEmployees).
				then().extract().response();
		statusCode = response.statusCode();
		responseHeader = response.headers().toString();		
	}
	
	
	public void getEmployees() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET,"GetEmployees");
		
	}
	
	
}
