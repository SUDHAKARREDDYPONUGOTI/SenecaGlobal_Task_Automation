package com.seneca.restapi.tests;

import org.testng.annotations.Test;

import com.sanaca.restassured.methods.RestHttpMethods;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RestAPIExampleTests {

	private static String generatedEmployeeId;
	private RestHttpMethods restTester;

	@BeforeTest
	public void beforeTest() {
		restTester = new RestHttpMethods();
	}


	@Test(dataProvider = "employeeDataProvider")
	public void createValidateAndDeleteEmployeeRecord(String employeeName, String salary, int age) {

		// Create a new employee record
		restTester.createEmployee(employeeName, salary, age);
		System.out.println(restTester.returnResponseHeaders());
		
		assertEquals(restTester.returnStatusCode(), 200);
		System.out.println(restTester.returnResponseAsString());

	}


	@DataProvider
	public Object[][] employeeDataProvider() {
		return new Object[][] {
			new Object[] { "LenovoTester", "3245", 26 }
			
		};
	}

	@Test
	public void getEmployees() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET,"/employees");

		String respbody = response.getBody().asString();
		System.out.println("Response Body is :" + respbody);

		int statuscode  = response.getStatusCode();
		System.out.println("Status Code is : " + statuscode);
		Assert.assertEquals(statuscode, 200);

		String statusline = response.getStatusLine();
		System.out.println("Status Line is : " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		JsonPath jsonresp = response.jsonPath();

		System.out.println("Total value is : " + jsonresp.get("data[0].id"));
		System.out.println("Total value is : " + jsonresp.get("data[0].employee_name"));
		System.out.println("Total value is : " + jsonresp.get("data[0].employee_salary"));
		System.out.println("Total value is : " + jsonresp.get("data[0].employee_age"));
		System.out.println("Total value is : " + jsonresp.get("data[0].profile_image"));


	}




	@AfterTest()
	public void afterTest() {
	}

}
