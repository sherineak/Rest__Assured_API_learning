package CRUD_Operation.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab271 {

    @Test

    public void getRquestPositive(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/1");
        Response response=r.when().log().all().get();
        response.then().log().all().statusCode(200);
    }

    @Test
    public void getRequestNegative(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/-1");
        Response response=  r.when().log().all().get();
        response.then().log().all().statusCode(404);
    }

}
