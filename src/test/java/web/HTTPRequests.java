package web;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;



/*
 * given()
 * content type, set cookies, add authentication, add parameters, set header info etc..
 * 
 * when()
 * get, post, put, delete
 * 
 * then()
 * validate status code, extract response, extract headers cookies & response body
 * 
 * https://reqres.in/ Rest API
 */


public class HTTPRequests {
	
	int id;

	//@Test(priority=1)
	void getUser() 
	
		{
				given()
				  
				.when()
				.get("https://reqres.in/api/users?page=2")
				   
				.then()
				     .statusCode(200)
				     .body("page",equalTo(2)) //other body content can also be verified
				     .header("Content-Type","application/json; charset=utf-8")
				     .log().all();
			       
					      
		}
	
	//Post Request using HashMap
	//@Test(priority=2)
	void createUser()
	
		{
		   HashMap hm = new HashMap();
		   hm.put("name","pavan");
		   hm.put("job", "trainer");
		
			
			id=given()
			    .contentType("application/json")
			    .body(hm)
			
			
			.when()
			   .post("https://reqres.in/api/users")
			   .jsonPath().getInt("id");
			
			//.then()
			//   .statusCode(201)
		    //   .log().all();
			
		
		}
	
	//Post Request using org.jason library
	//	@Test(priority=2)
		void createUser2()
		
			{
			   JSONObject data = new JSONObject();
			
			    data.put("name", "pavan");
			    data.put("job", "trainers");
			   //HashMap hm = new HashMap();
			   //hm.put("name","pavan");
			   //hm.put("job", "trainer");
			
				
				given()
				    .contentType("application/json")
				    .body(data.toString())
				
				
				.when()
				   .post("https://reqres.in/api/users")
				  // .jsonPath().getInt("id");
				
				.then()
				   .statusCode(201)
				   .body("name",equalTo("pavan"))
				   .body("job",equalTo("trainers"))
				   .log().all();
				
			
			}
		
		
		//Post Request using POJO Class
	//	@Test(priority=2)
		void createUser3()
		
			{
			
			   POJO_createUser3 data = new POJO_createUser3();
			   
			   data.setName("pavan1");
			   data.setJob("Teacher");
			   String cousrseArr[] = {"C","C++"};
			   data.setCourses(cousrseArr);
			   
			  //JSONObject data = new JSONObject();
			  //  data.put("name", "pavan");
			  //  data.put("job", "trainers");
			   //HashMap hm = new HashMap();
			   //hm.put("name","pavan");
			   //hm.put("job", "trainer");
			
				
				given()
				    .contentType("application/json")
				    .body(data)
				
				
				.when()
				   .post("https://reqres.in/api/users")
				  // .jsonPath().getInt("id");
				
				.then()
				   .statusCode(201)
				   .body("name",equalTo("pavan1"))
				   .body("job",equalTo("Teacher"))
				   .body("courses[0]",equalTo("C"))
				   .body("courses[1]",equalTo("C++"))
				   .log().all();
				
			
			}
		
		
		//Post Request using external JASON file
		@Test(priority=2)
		void createUser4() throws FileNotFoundException
		
			{
			   File file = new File(".\\body.json");
			   FileReader filereader = new FileReader(file);
			   JSONTokener jasonTokener = new JSONTokener(filereader);
			   JSONObject data = new JSONObject(jasonTokener);
			
				  
			  //POJO_createUser3 data = new POJO_createUser3();
			  //data.setName("pavan1");
			  // data.setJob("Teacher");
			  // String cousrseArr[] = {"C","C++"};
			  // data.setCourses(cousrseArr);
			   
			  //JSONObject data = new JSONObject();
			  //  data.put("name", "pavan");
			  //  data.put("job", "trainers");
			   //HashMap hm = new HashMap();
			   //hm.put("name","pavan");
			   //hm.put("job", "trainer");
			
				
				given()
				    .contentType("application/json")
				    .body(data.toString())
				
				
				.when()
				   .post("https://reqres.in/api/users")
				  // .jsonPath().getInt("id");
				
				.then()
				   .statusCode(201)
				   .body("name",equalTo("Scott"))
				   .body("job",equalTo("Teacher"))
				   .body("courses[0]",equalTo("C"))
				   .body("courses[1]",equalTo("C++"))
				   .header("Content-type","application/json; charset=utf-8")
				   .log().all();
				
			
			}
		
		
		
		
	// @Test(priority=3,dependsOnMethods={"createUser"})
	  void updateUser() 
	  
	  {
		 
		 HashMap hm = new HashMap();
		   hm.put("name","John");
		   hm.put("job", "teacher");
		
			
			given()
			    .contentType("application/json")
			    .body(hm)
			
			
			.when()
			   .put("https://reqres.in/api/users/"+id)
			   
			
			.then()
			    .statusCode(200)
			    .log().all();
			    
			
		 
	  }
	 
	// @Test(priority=4)
	  void deleteUser()
	  
	  {
		  given()
		  
		  .when()
		     .delete("https://reqres.in/api/users/userid/+id")
		  
		  .then()
		      .statusCode(204)
		      .log().all();
		  
	  }
	
}
