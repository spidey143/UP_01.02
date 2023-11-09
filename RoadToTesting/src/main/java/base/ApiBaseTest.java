package base;

import api.Specification;
import io.restassured.RestAssured;
import org.testng.annotations.*;
import steps.Steps;

public class ApiBaseTest implements Steps {

    @BeforeMethod
    public static void specificationConfiguring(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.requestSpecification = Specification.requestSpecification();
    }

}
