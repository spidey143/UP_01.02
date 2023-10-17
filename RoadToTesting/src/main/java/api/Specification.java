package api;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    private final static String URL = "https://reqres.in/api/";

    public static io.restassured.specification.RequestSpecification requestSpecification(){
      return new RequestSpecBuilder()
              .setBaseUri(URL)
              .setContentType(ContentType.JSON)
              .build();
    }


    public static ResponseSpecification responseSpecification(Integer code){
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();

    }
}
