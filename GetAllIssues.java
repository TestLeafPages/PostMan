package chaining.Jira;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIssues extends BaseRequest{

	@Test
	public void getAllRequests() {

		Response response = reqSepc
				.get("https://testleaf201902.atlassian.net/rest/api/2/search?jql=project='TUNA'");

		response.prettyPrint();		

		int statusCode = response.statusCode();
		System.out.println(statusCode);

		JsonPath json = response.jsonPath();

		List<String> allIssues = json.getList("issues.id");
		issueId = allIssues.get(allIssues.size()-1);
		System.out.println(issueId);

	}

}
