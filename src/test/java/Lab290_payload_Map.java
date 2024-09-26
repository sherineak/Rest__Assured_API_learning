import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lab290_payload_Map {
    //payload using Map
    //POST Request - payload - String (We did payload a string previously)
//    String payload ="{\n" +
//            "    \"firstname\" : \"Sherine\",\n" +
//            "    \"lastname\" : \"Antony\",\n" +
//            "    \"totalprice\" : 111,\n" +
//            "    \"depositpaid\" : true,\n" +
//            "    \"bookingdates\" : {\n" +
//            "        \"checkin\" : \"2018-01-01\",\n" +
//            "        \"checkout\" : \"2019-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\" : \"Breakfast\"\n" +
//            "}";

    @Test
    public void testPostRequest(){
        Map<String,Object> jsonBdyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        jsonBdyUsingMap.put("firstname",firstName);
        jsonBdyUsingMap.put("lastname",lastName);
        jsonBdyUsingMap.put("totalprice",faker.random().nextInt(1000));
        jsonBdyUsingMap.put("depositpaid",faker.random().nextBoolean());

        //Bookingdates is another Map in the payload so
        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBdyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBdyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBdyUsingMap);

        RequestSpecification r = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        r.given();
        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBdyUsingMap);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);     // To verify the response in future

        validatableResponse = response.then();
        validatableResponse.statusCode(200);



    }

}
