package PayLoad;

import java.util.Random;

public class PayLoad {
	public static String result;
	
	public static String createAccessToken() {
		Random rand = new Random();
		int low =500;
		int high =999;
		 result = String.valueOf(rand.nextInt(high-low)+high);
		return "{\r\n"
				+ "   \"clientName\": \"Postman\",\r\n"
				+ "   \"clientEmail\": \"HariprasathcseSelenium"+result+"@gmail.com\"\r\n"
				+ "}";
	}
	
	public static String createNewOrder() {
		return "{\r\n"
				+ "  \"bookId\": 1,\r\n"
				+ "  \"customerName\": \"John\"\r\n"
				+ "}";
	}
	
	public static String updateNewOrderForCustomerName() {
		return "{\r\n"
				+ "  \"customerName\": \"Hari\"\r\n"
				+ "}";
	}
	
}
