package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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


    //endpoint = /posts/{postId}
    public static void performPathParameter(){
        given()
                .contentType(ContentType.JSON)
        .with()
                .pathParams("postId", 3)
        .when()
                .get("http://localhost:3000/posts/{postId}")
        .then()
                .body("author", containsString("Paulo Valentim"));
    }

    public static void performQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", 21)
        .when()
                .get("http://localhost:3000/posts/")
        .then()
                .body("author", hasItem("Sheldon Nascimento"));
    }


}
