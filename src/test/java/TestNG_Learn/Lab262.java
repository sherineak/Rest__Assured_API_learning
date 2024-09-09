package TestNG_Learn;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab262 {
    @Description("TC#1 - Verify GET Request 1")
    @Test(enabled = false)
    public void getRequest() {
        System.out.println("TC1");
    }

    @Description("TC#2 - Verify GET Request 2")
    @Test
    public void getRequest1() {
        System.out.println("TC2");
    }

    @Description("TC#3 - Verify GET Request 3")
    @Test
    public void getRequest2() {
        System.out.println("TC3");
    }

}
