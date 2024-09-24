package Testng_Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class Lab288_Listeners_Example {

    @Test(groups = "sanity")
    public void test1(){
        System.out.println("Test1");
        Assert.assertTrue(false);
    }
    @Test(groups = "Sanity")
    public void test2(){
        System.out.println("Test2");
        Assert.assertTrue(true);
    }

    @AfterSuite     // this is not a test case, this will execute after the execution of all testcases
    public void emailToQALead(){
        //Send email
        System.out.println("After Suite Executing ....");
        System.out.println("Sending email to QA Lead "); // we can ask code to send mail to chatgpt
    }

}
