package TestNg_Grouping_TestCases;

import org.testng.annotations.Test;

public class Lab283 {
    @Test(groups = {"init"},priority =1)
    public void getToken(){
        System.out.println("ServerSatrtedOK");

    }
    @Test(groups = {"init"},priority = 2)
    public void getBookingId(){
        System.out.println("initEnviornment");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testPutReq(){
        System.out.println("Now I will run");
    }
}
