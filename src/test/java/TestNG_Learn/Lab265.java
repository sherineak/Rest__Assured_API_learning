package TestNG_Learn;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab265 {
    @Description("TC#1")
    @Test
    public void testCase(){
        // Assertions --> verify Expected = Actual Result
        // Status code 200 = status code 200
        // Testng two types of assertion
        // 1. Soft assertions
        SoftAssert s = new SoftAssert();
        s.assertEquals("Sherine","sherine","not equal"); // message if failed
        System.out.println("End of the program");
        s.assertAll();

        // Hard Assertion
//        Assert.assertEquals("Sherine","Sherine");
//        System.out.println("end of the program");


    }
}
