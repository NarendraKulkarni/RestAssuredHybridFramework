package web1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HeaderDemo {
	
	
		@Test
		void testheaders() {
			
			
							given()
							
							.when()
							     .get("https://www.google.com/")
							
							.then()
								.header("Content-type","text/html; charset=ISO-8859-1")
								.header("Content-Encoding", "gzip")
								.header("Server", "gws")
								.log().all();
							
							
		}
	

}
