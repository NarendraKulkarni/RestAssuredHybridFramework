package web3;


import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {
	
 //Myfile.json is kept in resources folder
	
	@Test
	void jsonschemavalidation()
	{
		
		given()
		
		 .when()
		 	.get("https://reqres.in/api/users?page=2") //convert json to jsonschema  converter by using //https://jsonformatter.org/json-to-jsonschema
		 
		 .then()
		 	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("myfile.json"));
		
		 	
		 	
	}

}
