package requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getAllRequests() {
		
		RestAssured.baseURI = "https://dev28357.service-now.com/api/now/table/incident";
		AuthenticationScheme basic = RestAssured.basic("admin", "Tuna@123");
		// This is for Jira: 
		// RestAssured.preemptive().basic(userName, password)
		RestAssured.authentication = basic;
		Map<String,String> parametersMap = new HashMap<String,String>();
		parametersMap.put("urgency", "1");
		parametersMap.put("priority", "1");
		
		Response response = RestAssured
				.given()
				//.params(parametersMap)
				.param("urgency", "1")
				.get();
		
		//response.prettyPrint();		
		
		int statusCode = response.statusCode();
		System.out.println(statusCode);
		
		JsonPath json = response.jsonPath();
		
		List<String> allNumbers = json.getList("result.number");
		System.out.println(allNumbers.size());
		
		/*for (String eachIncident : allNumbers) {
			System.out.println(eachIncident);
		}*/
		
		
		
		
	}

}
