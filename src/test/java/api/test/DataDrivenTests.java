package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPOSTUser(String userID, String userName, String firstName, String LastName,String Email, String Password, String Phone)
	
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		
		
		
	Response response = UserEndpoints.createUser(userPayload);	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByNames (String userName)
	
	{
		Response response1 = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response1.getStatusCode(), 200);
	}
	
}


