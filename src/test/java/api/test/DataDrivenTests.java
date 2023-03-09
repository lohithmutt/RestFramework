package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void postUser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void getUser(String userName) 
	{
		Response response=UserEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	@Test(priority=3, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void updateUser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		
		Response response=UserEndPoints.updateUser(userPayload,userName);
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	
	@Test(priority=4, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void deleteUser(String userName)
	{
			Response response=UserEndPoints.deleteUser(userName);
			Assert.assertEquals(response.getStatusCode(),200);	
	
	}
	
	
	
}
