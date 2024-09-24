package CRUD_Operation_FULL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Lab277 {
    String token;
    Integer bookingId;
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @BeforeTest
    public void getAToken(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        response = rs.when().post();

        vr = response.then();   // to get token
        vr.statusCode(200);

        // Extract the Token from this
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingId(){
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Antony\",\n" +
                "    \"totalprice\" : 999,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        response = rs.post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr= response.then().log().all();
        vr.statusCode(200);

        // Extract Booking Id
        bookingId = response.then().log().all().extract().path("bookingid");
        String firstname = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstname);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);
    }
    @Test
    public void testPutRequestPositive(){
        String payload ="{\n" +
                "    \"firstname\" : \"Sherine\",\n" +
                "    \"lastname\" : \"Antony\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        //Put Request

        response=rs.when().put();

        vr = response.then().log().all();
        vr.statusCode(200);

        String firstnameResponse= response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstnameResponse,"Sherine");

        //To Print full response
        String fullResponseFromJSONString = response.asString();
        System.out.println(fullResponseFromJSONString);

        //Verify all the keys and value pairs in the response
        //firstname, lastname, deposit, total , checkin

         // 4 ways you can verify the response

        //1. Matchers (Default Rest Assured Matchers)
        vr.body("firstname", Matchers.equalTo("Sherine"));

        //2. TestNG Asserts -  Assert.assertEquals(firstNameResponse,"Sherine");
        String firstnameResponse1 = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstnameResponse1,"Sherine");

        //3. TestNG Assertion with JSON path lib
        JsonPath jsonPath = new JsonPath(fullResponseFromJSONString);
        String firstnameJsonPathExtracted = jsonPath.getString("firstname");
        String lastnameJsonPathExtracted = jsonPath.getString("lastname");
        Integer totalPriceJsonPathExtracted = jsonPath.getInt("totalprice");
        String checkinDateJsonPathExtracted = jsonPath.getString("bookingdates.checkin");
        Assert.assertEquals(firstnameJsonPathExtracted,"Sherine");
        Assert.assertEquals(lastnameJsonPathExtracted,"Antony");
        Assert.assertEquals(totalPriceJsonPathExtracted,111);
        Assert.assertEquals(checkinDateJsonPathExtracted,"2018-01-01");
        Assert.assertNotNull(totalPriceJsonPathExtracted);

        // if Array path will be like this
        //String checkin  = jsonPath.getInt("[0]["\bookinID\"]["\checkin\"]");
        //System.out.println(checkin);

        //4. AssertJ Matching
        assertThat(firstnameJsonPathExtracted).isNotBlank().isEqualTo("Sherine").isAlphabetic().hasSizeLessThan(40);
        assertThat(totalPriceJsonPathExtracted).isNotZero().isNotNegative();






    }


}
