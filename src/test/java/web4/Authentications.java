package web4;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {
	
	//basic
	//Digest
	//preemtive
	//auth2
	//key authetication
	
	//@Test(priority=1)
	void testBasicAuthentication() {
		
		given()
			.auth().basic("postman","password")
		
		 .when()
		      .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		    .statusCode(200)
		    .body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//@Test(priority=2)
	void testDigestAuthentication() {
		
		given()
			.auth().digest("postman","password")
		
		 .when()
		      .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		    .statusCode(200)
		    .body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//@Test(priority=3)
	void testPreemtiveAuthentication() {
		
		given()
			.auth().preemptive().basic("postman","password")
		
		 .when()
		      .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		    .statusCode(200)
		    .body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	
	//@Test 
	void testAPIkeyAuthentication() {
		
		
		given()
		    .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		 .when()
		 	.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		 .then()
		 	.statusCode(200)
		 	.log().all();
		 	
	}
	
	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		System.out.println("Full Name "+fullName);
		System.out.println("first Name "+firstName);
		System.out.println("last Name "+lastName);
	}

}
