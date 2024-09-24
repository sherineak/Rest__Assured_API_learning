package CRUD_Operation.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab275 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "8b95d3336db1d94";
    String bookingId = "/470";
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    @Test
    public void testDeleteRequestNonBDD(){
        String BASE_PATH_UPDATED = Base_Path + bookingId;
        System.out.println(BASE_PATH_UPDATED);


                r.baseUri(Base_URL);
                r.basePath(BASE_PATH_UPDATED);
                r.contentType(ContentType.JSON);
                r.cookie("token",token);
                r.log().all();

                response = r.when().log().all().delete();

                vr = response.then().log().all();
                vr.statusCode(201);




    }

}
