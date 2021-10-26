package utilities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri("http://localhost:3000");
        reqBuilder.setContentType(ContentType.JSON);
        var requestSpec = reqBuilder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void getOpsWithPathParameter(String url, Map<String, String> pathParams) throws URISyntaxException {
        //ACT
        Request.pathParams(pathParams);
        Request.get(new URI(url));
    }

    public static void getOps(String url) throws URISyntaxException {
        //ACT
        Request.get(new URI(url));
    }
}
