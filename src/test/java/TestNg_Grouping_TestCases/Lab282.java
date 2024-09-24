package TestNg_Grouping_TestCases;

import org.testng.annotations.Test;

public class Lab282 {
    @Test
    public void getToken(){
        System.out.println("Token");
    }
    @Test
    public void getBookingID(){
        System.out.println("BookingID");
    }
    @Test(dependsOnMethods = {"getToken","getBookingID"})
    public void testPutRequest(){
        System.out.println("PUT");
    }
    @Test(dependsOnMethods = {"getToken","getBookingID"})
    public void testDeleteRequest(){
        System.out.println("Delete");
    }



}
