package web2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {
	
	//@Test(priority=1)
	void testJSONResponse() 
	{
		//Approach1
		/*
		given()
			.contentType(ContentType.JSON)
		
		
		  .when()
		  	  .get("https://reqres.in/api/users?page=2&id=5")
		  
		  .then()
		  	  .statusCode(200)
		  	  .header("Content-Type", "application/json; charset=utf-8")
		  	  .body("data.id",equalTo(5))//Use JasonPathFinder.com to get jason path for field names
		  	  .body("data.last_name",equalTo("Morris"));
		  */
		
		//Approach2   ===> Getting body into variable and then verifying
		
			Response res = given()
				.contentType(ContentType.JSON)
				
			   .when()
			   		.get("https://reqres.in/api/users?page=2&id=5");
			
			   Assert.assertEquals(res.statusCode(),200); //validation1
			   Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
			   String lastName=  res.jsonPath().get("data.last_name").toString();
			   Assert.assertEquals(lastName,"Morris");
			   
	}

	@Test(priority=2)
	void testJSONResponseBodyData() 
	{
		
		
		//Approach2   ===> Getting body into variable and then verifying
		
		Response res = given()
				.contentType(ContentType.JSON)
				
						.when()
						.get("https://reqres.in/api/users?page=2");
			
			 /*  Assert.assertEquals(res.statusCode(),200); //validation1
			   Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
			   String lastName=  res.jsonPath().get("data.last_name").toString();
			   Assert.assertEquals(lastName,"Morris");
			 */
			
			//JSONObject Class
		
			JSONObject jsonobj = new JSONObject(res.asString());//response need to be converted to string format before it passed to JSONObject
			for (int i = 0; i<jsonobj.getJSONArray("data").length();i++)
				
			{
				
				String firstName = jsonobj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
				System.out.println(firstName);
			
				
			}
			
			
			
	}

	
}
