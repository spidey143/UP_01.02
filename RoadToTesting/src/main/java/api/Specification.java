package api;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.http.ContentType.JSON;

public class Specification {

    public static RequestSpecification requestSpecification(){
      return new RequestSpecBuilder()
              .setBaseUri(baseURI)
              .setContentType(JSON)
              .build();
    }


    public static ResponseSpecification responseSpecification(Integer code){
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }
}
