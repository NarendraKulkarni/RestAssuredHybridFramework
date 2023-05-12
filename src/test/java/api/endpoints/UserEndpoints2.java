package api.endpoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
public class UserEndpoints2 {
	
	static ResourceBundle getURL()
	{
		//Method to import URL From properties files
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	
	public static Response createUser(User payload)
			{
				String createUser = getURL().getString("createUser");
				
			Response res=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						 .when()
							.post(createUser);
						
						return res;	
							
				}
		
		public static Response readUser(String userName)
		{
			 String GetUser = getURL().getString("GetUser");
			Response res=given()
							.pathParam("username", userName)
						  .when()
						     .get(GetUser);
				
				return res;	
					
		}
		
		public static Response updateUser(String userName, User payload)
		{
			String DeleteUser = getURL().getString("DeleteUser");
	Response res=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(payload)
				 .when()
					.put(DeleteUser);
				
				return res;	
					
		}
		
		public static Response deleteUser(String userName)
		{
			String UpdateUser = getURL().getString("UpdateUser");
			Response res=given()
							.pathParam("username", userName)
						  .when()
						     .delete(UpdateUser);
				
				return res;	
					
		}
}
