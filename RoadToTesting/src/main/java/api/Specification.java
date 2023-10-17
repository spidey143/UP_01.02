package api;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    private final static String URL = "https://reqres.in/api/";

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(URL)
            .setContentType(ContentType.JSON)
            .build();


    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();

    }

    public static void installSpecifications(RequestSpecification requestSpecification, ResponseSpecification responseSpecification){
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
