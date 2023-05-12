package web3;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
	
	
	@Test
	void xmlschemavalidation()
	{
		given()
		
			.when()
			  .get("http://restapi.adequateshop.com/api/Traveler?page=1") //convert xml to XSD format https://www.liquid-technologies.com/online-xml-to-xsd-converter
			
			.then()
				.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("myxmlfile.xsd"));
			
		
	}

}
