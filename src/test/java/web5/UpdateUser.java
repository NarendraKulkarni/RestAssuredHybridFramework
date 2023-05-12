package web5;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	
	@Test
	void test_updateUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", faker.name().fullName());
		jsonObj.put("gender","Male");
		jsonObj.put("email",faker.internet().emailAddress());
		jsonObj.put("status", "active");
		
		String bearerToken="c35e10e748c6f113775527bcef204e9929b4c9f4b995a8ee253eec46aed57b06";
		
		int id = (Integer) context.getAttribute("user_id");	
	given()
		    .headers("Authorization", "Bearer "+bearerToken)
		    .contentType("application/json")
		    .pathParam("id", id)
		    .body(jsonObj.toString())
		 
		 .when()
		 	.put("https://gorest.co.in/public/v2/users/{id}")
			
         .then()
         	.statusCode(200)
         	.log().all();
		
	}

}
