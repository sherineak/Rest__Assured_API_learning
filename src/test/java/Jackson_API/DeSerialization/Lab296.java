package Jackson_API.DeSerialization;

import Gson.Serialization.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.awt.print.Book;

public class Lab296 {
    @Test
    public void DesSerialization() throws JsonProcessingException {
        String jsonString = "{\n" +
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
        ObjectMapper objectMapper = new ObjectMapper();
        Booking booking = objectMapper.readValue(jsonString,Booking.class);
        System.out.println(booking);
        System.out.println(booking.getFirstname());

    }

}
