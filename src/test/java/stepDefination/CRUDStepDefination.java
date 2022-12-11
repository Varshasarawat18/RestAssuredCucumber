package stepDefination;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDStepDefination 
	
{		Response response;
		RequestSpecification request;
		Map <String,Object> MapObj;
	
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  
		request= RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions

		response = request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(expResponseCode, response.getStatusCode());
		
		
}	
	@When("I Provide {string} and {string} as input")
	public void i_Provide_and_as_input(String name, String salary) {
	    // Write code here that turns the phrase above into concrete actions
		MapObj= new HashMap<String,Object>();
		MapObj.put("Name", name);
		MapObj.put("Salary", salary);
		
		
	}
	
	@When("I perform the POST operartion")
	public void i_perform_the_POST_operartion() {
	    // Write code here that turns the phrase above into concrete actions 
		
		Response response = request	
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(MapObj)
							.post("create");
		System.out.println(response.getBody().asString());
	    		
	}

	@When("Employee should be created")
	public void employee_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
		response = request.post();
	}

}
