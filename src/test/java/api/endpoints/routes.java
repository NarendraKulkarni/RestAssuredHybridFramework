package api.endpoints;

// Swagger URI = https://petstore.swagger.io

//	  POST 	 Create User 	https://petstore.swagger.io/v2/user
//	  GET  	 Get User		https://petstore.swagger.io/v2/user/{username}
//	  DELETE Delete User 	https://petstore.swagger.io/v2/user/{username}
//	  PUT -  Update User     https://petstore.swagger.io/v2/user/{username}	   

public class routes {
	
	
	//User API  Module 
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_url = base_url+"/user";
	public static String get_url =  base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	
	//Store API Module
	
	//Pet API  Module 
}
