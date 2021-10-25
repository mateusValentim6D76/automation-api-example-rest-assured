package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import io.restassured.http.ContentType;

public class GetPostSteps {

	@Given("I perform GET operation for {string}")
	public void i_perform_get_operation_for(String url) {
		given().contentType(ContentType.JSON);
	}

	@Given("I perform GET for the post number {string}")
	public void i_perform_get_for_the_post_number(String postNumber) {
		when().get(String.format("http://localhost:3000/posts/%s", postNumber))
		.then().body("author", is("Mateus Valentim"));
	}

	@Then("I should see the author name {string}")
	public void i_should_see_the_author_name(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
