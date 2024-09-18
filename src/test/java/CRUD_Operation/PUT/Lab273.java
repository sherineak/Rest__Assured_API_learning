package CRUD_Operation.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "f80e2c0a0a13449";
    String bookingId = "/1970";
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    @Test
    public void testPutRequestNonBDD(){
        String BASE_PATH_UPDATED = Base_Path + bookingId;
        System.out.println(BASE_PATH_UPDATED);
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

                r.baseUri(Base_URL);
                r.basePath(BASE_PATH_UPDATED);
                r.contentType(ContentType.JSON);
                r.cookie("token",token);
                r.body(payload).log().all();

                response = r.when().log().all().put();

                vr = response.then().log().all();
                vr.statusCode(200);
                vr.body("firstname", Matchers.equalTo("James"));
                vr.body("lastname",Matchers.equalTo("Brown"));


    }

}
