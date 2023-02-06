import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import PayLoad.PayLoad;

public class SauceLabDemoAPI {
	
	public static void main(String[] args) {
		
		//POST-Create Access Token
		
		RestAssured.baseURI ="https://simple-books-api.glitch.me";
		String response = given().header("Content-Type", "application/json")
				.body(PayLoad.createAccessToken())
				.when().post("/api-clients/")
				.then().assertThat().statusCode(201).extract().asString();
		JsonPath js = new JsonPath(response);
		String strAccessToken = js.getString("accessToken");
		System.out.println(response);
		System.out.println("Access Token Generated : "+strAccessToken);
	System.out.println("----------------------------------------------------------------");	
		
		//POST - Create new Order
		
		String NewOrderCreationResponse = given().header("Authorization", "Bearer "+strAccessToken).header("Content-Type", "application/json").body(PayLoad.createNewOrder())
		.when().post("/orders")
		.then().assertThat().statusCode(201).extract().asString();
		System.out.println(NewOrderCreationResponse);
		JsonPath postjs = new JsonPath(NewOrderCreationResponse);
		String strNewOrderID = postjs.getString("orderId");
		System.out.println("Order-ID : "+strNewOrderID);
		System.out.println("----------------------------------------------------------------");
		
		//GET - Current Newly Created Order
		
		String getParticularOrderCreated =given().header("Authorization", "Bearer "+strAccessToken)
		.queryParam("orderId", strNewOrderID)
		.when().get("/orders")
		.then().assertThat().log().all().statusCode(200).extract().asString();
		System.out.println(getParticularOrderCreated);
		System.out.println("----------------------------------------------------------------");
		
		//PATCH - update Customer Name from John to Hari
		
		String UpdateCustomerNameResponse =given().header("Authorization", "Bearer "+strAccessToken).header("Content-Type", "application/json")
		.body(PayLoad.updateNewOrderForCustomerName())
		.when().patch("/orders/"+strNewOrderID)
		.then().assertThat().log().all().statusCode(204).extract().asString();
		System.out.println(UpdateCustomerNameResponse);
		System.out.println("----------------------------------------------------------------");
		
		//GET- Verifying if the Customer Name is changed from john to Hari
		
		String UpdatedCustomerNameResponse =given().header("Authorization", "Bearer "+strAccessToken)
				.queryParam("orderId", strNewOrderID)
				.when().get("/orders")
				.then().assertThat().log().all().statusCode(200).extract().asString();
		System.out.println(UpdatedCustomerNameResponse);
		JsonPath getCusNamejs = new JsonPath(UpdatedCustomerNameResponse);
		String updatedCustomerName = getCusNamejs.getString("customerName");
				System.out.println("Updated Customer Name : "+updatedCustomerName);
				System.out.println("----------------------------------------------------------------");
	
	 //DELETE - Deleting the Created Order
		
		String deletedResponse =given().log().all().header("Authorization", "Bearer "+strAccessToken)
		.when().delete("/orders/"+strNewOrderID)
		.then().assertThat().log().all().statusCode(204).extract().asString();
		System.out.println("Deleted Response :"+deletedResponse);
	}

}
