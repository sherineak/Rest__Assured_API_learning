package TestNG_Learn;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab267 {
    // Integration Scenario
    //CRUD
    //Create Booking   --> Id
    //Create Auth --> Token
    // Put --> Id , Token
    // Delete --> ID
    // Get -->  verify Should not exist ..

 String token;
 Integer bookingID;

 public String getToken(){
     token = "123";
     return token;
 }
 @BeforeTest
    public void getTokenAndBookingID(){
     token = getToken();
     //POST1 Req
     // POST1 code
     bookingID = 123;
 }
 @Test
    public void testPUTReq(){
     System.out.println(token);
     System.out.println(bookingID);
     //Put Code
 }

 @Test
    public void testDeleteReq(){
     System.out.println(token);
     System.out.println(bookingID);
     //Delete code
 }
 @Test
    public void testGetReq(){
     System.out.println(token);
     System.out.println(bookingID);
     // Delete Code  - to check deleted record
 }

}
