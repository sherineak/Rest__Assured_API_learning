package Gson.DeSerialization;

import Gson.Serialization.Booking;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab294 {
    @Test
    public void DeSeralizationTest(){
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
        Gson gson = new Gson();
        Booking booking= gson.fromJson(jsonString,Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());

        Assert.assertEquals(booking.getFirstname(),"James");

    }
}
