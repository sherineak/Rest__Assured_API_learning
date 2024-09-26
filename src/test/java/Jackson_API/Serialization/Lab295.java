package Jackson_API.Serialization;

import Gson.Serialization.Booking;
import Gson.Serialization.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.testng.annotations.Test;

public class Lab295 {
    @Test
    public void SerialUsingJackson() throws JsonProcessingException {


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

        // Object to json String by using Jackson Api (Serialization)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);



    }
}
