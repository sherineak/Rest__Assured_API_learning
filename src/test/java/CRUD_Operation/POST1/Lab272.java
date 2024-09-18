package CRUD_Operation.POST1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab272 {
    @Test
    public void testBDDStylePostPositive(){
        //Post Request
        //URL
        //Body - payload - Json
        //Header - Content Type
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String payload = "{\n" +
                "    \"firstname\" : \"Sherine\",\n" +
                "    \"lastname\" : \"Antony\",\n" +
                "    \"totalprice\" : 999,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured.given().baseUri(Base_URL).basePath(Base_Path)
                .contentType(ContentType.JSON).log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);

    }
}
