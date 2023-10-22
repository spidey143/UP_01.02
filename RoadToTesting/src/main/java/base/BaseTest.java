package base;

import api.Specification;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.*;
import steps.Steps;

public class BaseTest implements Steps {

    @BeforeMethod
    public static void specificationConfiguring(){
        RestAssured.baseURI = "https://reqres.in/api/";
        RestAssured.requestSpecification = Specification.requestSpecification();
    }

}
