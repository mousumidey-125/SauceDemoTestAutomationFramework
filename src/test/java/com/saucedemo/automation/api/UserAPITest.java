package com.saucedemo.automation.api;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

public class UserAPITest {
	
	@BeforeClass
	public void  setup() {
		RestAssured.baseURI = APIConstants.BASE_URL;
	}
	
	@Test
	public void verifyGetAllUsers() {
		RestAssured.given().when().get(APIConstants.GET_USERS).then().statusCode(200).body("size()", equalTo(10));
	}
	
	@Test
	public void verifyGetSingleUser() {
		RestAssured.given().when().get(APIConstants.GET_SINGLE_USER).then().statusCode(200).body("name", equalTo("Leanne Graham")).body("username",equalTo("Bret"));
	}
	
	@Test
	public void verifyCreatePost() {
		String requestBody = "{ \"title\": \"Test Post\", \"body\": \"This is a test post\", \"userId\": 1 }";
		
		RestAssured.given().header("Content-Type","application/json").body(requestBody).when().post(APIConstants.CREATE_POST).then().body("id", notNullValue());
	}
	
	@Test
	public void verifyUpdatePost() {
	    String requestBody = "{ \"id\": 1, \"title\": \"Updated Title\", \"body\": \"Updated body content\", \"userId\": 1 }";

	    RestAssured.given()
	               .contentType(ContentType.JSON)
	               .body(requestBody)
	               .when()
	               .put(APIConstants.UPDATE_POST)
	               .then()
	               .statusCode(200)
	               .body("title", equalTo("Updated Title"));
	}
	
	@Test
	public void verifyDeletePost() {
		RestAssured.given().when().delete(APIConstants.DELETE_POST).then().statusCode(200);
	}
	
	@Test
	public void verifyGetInvalidUser_returns404() {
	    RestAssured.given()
	               .when()
	               .get("/users/abc")
	               .then()
	               .statusCode(404);
	}
}
