package Gson.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Lab293 {

    //List of object( eg :2 payloads) through Arraylist
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Description("Tc#1 Verify that create booking is working with valid payload")
    @Test
    public void testTwoPayloadUsingArray(){
        //Post Request

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Jain");
        booking.setLastname("John");
        booking.setTotalprice(120);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2019-01-01");
        bookingdates.setCheckout("2020-01-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking.toString());

        Booking booking1 = new Booking();
        booking1.setFirstname("Brown");
        booking1.setLastname("Sanin");
        booking1.setTotalprice(120);
        booking1.setDepositpaid(true);

        BookingDates bookingdates1 = new BookingDates();
        bookingdates1.setCheckin("2019-01-01");
        bookingdates1.setCheckout("2020-01-01");

        booking1.setBookingdates(bookingdates1);
        booking1.setAdditionalneeds("Breakfast");
        System.out.println(booking1.toString());

        // if you want more than one record so there is  arraylist , but when run its printing not proper way

        ArrayList payload = new ArrayList();
        payload.add(booking);
        payload.add(booking1);
        System.out.println(payload);

        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(booking);
        r.body(booking1);


        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);     // To verify the response in future

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
