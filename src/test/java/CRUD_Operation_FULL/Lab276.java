package CRUD_Operation_FULL;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab276 {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("2");
    }
    @Test
    public void t3(){
        //After getting token & Booking Id from above methods
        System.out.println("3");
    }
}
