package chaining.Jira;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletIssue extends BaseRequest {

	@Test(dependsOnMethods="chaining.Jira.GetAllIssues.getAllRequests")
	public void deleteIncident() {
		
		Response response = reqSepc.delete("/"+issueId);
		if(response.statusCode() == 204) {
			System.out.println("The record is deleted");
		}
	}
}
