package chaining.Jira;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification reqSepc;
	public static String issueId;
	
	@BeforeSuite
	public void setContext() {		

		RestAssured.baseURI = "https://testleaf201902.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("leaf201906@gmail.com", "Leaf@123");		
		
		reqSepc = RestAssured 
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);
	}

}
