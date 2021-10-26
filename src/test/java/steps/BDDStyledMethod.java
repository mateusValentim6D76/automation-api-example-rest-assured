package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class BDDStyledMethod {

    public static void simpleGETPost(String postNumber){
        given().contentType(ContentType.JSON)
                .when().get(String.format("http://localhost:3000/posts/%s", postNumber))
                .then().body("author", is("Mateus Valentim"));
    }

    public static void performConstainsCollection(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/posts/")
        .then()
                .body("author", containsInAnyOrder("Mateus Valentim", "Thalia Lima", "Renato Augusto", null)).statusCode(200);
    }


}
