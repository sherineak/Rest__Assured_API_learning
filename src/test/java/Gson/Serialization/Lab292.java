package Gson.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab292 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Description("Tc#1 Verify that create booking is working with valid payload")
    @Test
    public void testNONBDDStylePostPositive(){
        //Post Request

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Sherine");
        booking.setLastname("Antony");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking.toString());


        r.given();
        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(booking);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);     // To verify the response in future

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
