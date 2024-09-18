package CRUD_Operation.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab274 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "01af40ee878ca4c";
    String bookingId = "/2333";
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    @Test
    public void testPatchRequestNonBDD(){
        String BASE_PATH_UPDATED = Base_Path + bookingId;
        System.out.println(BASE_PATH_UPDATED);
        String payload = "{\n" +
                "    \"firstname\" : \"Sherine\",\n" +

                "}";

                r.baseUri(Base_URL);
                r.basePath(BASE_PATH_UPDATED);
                r.contentType(ContentType.JSON);
                r.cookie("token",token);
                r.body(payload).log().all();

                response = r.when().log().all().patch();

                vr = response.then().log().all();
                vr.statusCode(200);
                vr.body("firstname", Matchers.equalTo("Sherine"));



    }

}
