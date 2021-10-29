package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import utilities.RestAssuredExtension;

public class GetPostSteps {

	public static ResponseOptions<Response> response;

	@Given("I perform GET operation for {string}")
	public void i_perform_get_operation_for(String url) throws Throwable{
		 response = RestAssuredExtension.GetOps(url);
	}

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name(String authorName) {
		assertThat(response.getBody().jsonPath().get("author"), hasItem("Mateus Valentim"));

	}

	@Then("I should see the author names")
	public void iShouldSeeTheAuthorNames() {
		BDDStyledMethod.performConstainsCollection();
	}

	@Then("I should see verify GET path Parameter")
	public void iShouldSeeVerifyGETParameter() {
		BDDStyledMethod.performPathParameter();
	}

	@Then("I should see verify GET query Parameter")
	public void i_should_see_verify_get_query_parameter() {
		BDDStyledMethod.performQueryParameter();
	}

	@Given("I perform POST operation for {string}")
	public void i_perform_post_operation_for(String string) {
		BDDStyledMethod.performPOSTWithBodyParameter();
	}
}
