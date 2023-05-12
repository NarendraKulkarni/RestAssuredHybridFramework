package web1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	
	//@Test
	void testCookies() {
		
		
						given()
						
						.when()
						     .get("https://www.google.com/")
						
						.then()
							 .cookie("AEC","AUEFqZfvcZbUqcVipq7AjkHO29yAWswuiGkFg22RYtVtdapNvHCyBXlDxh4")
						     .log().all();
						
	}

	@Test
	void testCookiesinfo() {
		
		
		Response res=given()
		
		.when()
		     .get("https://www.google.com/"); // Statement should end at when() by semicolon to store value in given(), then() will not be there
		
		
		//get single cookie
		String cookie_value = res.getCookie("AEC");
		System.out.println("The value of cookie is ---->"+cookie_value);
		
		Map<String, String> cookies_value = res.getCookies();
		for(String k: cookies_value.keySet())
		{
			String cookie_value1=res.getCookie(k);
			System.out.println(k+"       "+cookie_value1);
					
		}
		
}
}
