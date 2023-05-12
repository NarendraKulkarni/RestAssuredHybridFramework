package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User  userPayload;
	
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	@Test(priority=1)
	public void testCreateUserPOSTRequest() 
	{
		
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=2)
	public void testReadUserGETRequest() 
	{
		
		Response response = UserEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateGETRequest() 
	{
		//Update User with new data from Faker
		userPayload.setLastName(faker.name().lastName());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		testReadUserGETRequest(); // read user data again 
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUserGETRequest() 
	{
		
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
