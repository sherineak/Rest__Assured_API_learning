package CRUD_Operation.POST1;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab272_NONBDD {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Description("Tc#1 Verify that create booking is working with valid payload")
    @Test
    public void testNONBDDStylePostPositive(){
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


                r.given();
                r.baseUri(Base_URL);
                r.basePath(Base_Path);
                r.contentType(ContentType.JSON).log().all();
                r.body(payload);

                response = r.when().log().all().post();
                String responseString = response.asString();
                System.out.println(responseString);     // To verify the response in future

                validatableResponse = response.then();
                validatableResponse.statusCode(200);

    }
    @Description("Tc#2 Verify that create booking is not working without payload")
    @Test
    public void testNONBDDStylePostNegative(){
        //Post Request
        //URL
        //Body - payload - Json
        //Header - Content Type
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String payload = "";


        r.given();
        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);     // To verify the response in future

        validatableResponse = response.then();
        validatableResponse.statusCode(500);

    }
}
