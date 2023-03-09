package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		
	Response response=	given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_user);
		
		return response;
	}
	
	public static Response readUser(String username) {
		
		Response response=	given()
				.pathParam("username", username)
			.when()
			.get(Routes.get_user);
			
			return response;
		}
	
	public static Response updateUser(User payload,String username) {
		
		Response response=	given()
				.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.put(Routes.put_user);
			
			return response;
		}
	
	public static Response deleteUser(String username) {
		
		Response response=	given()
				.pathParam("username", username)
			.when()
			.delete(Routes.delete_user);
			
			return response;
		}
}
