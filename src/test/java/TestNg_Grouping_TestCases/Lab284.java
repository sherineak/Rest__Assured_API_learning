package TestNg_Grouping_TestCases;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab284 {
    @Parameters("browser")
    @Test(priority = 1)
    public void testDemo1(String value){
        System.out.println("Browser is  " +value);
        switch (value){
            case "firefox":
                //firefox code
                System.out.println("firefox starting and running cases");
                break;
            case "chrome":
                System.out.println("Chrome starting and Running TC");
                break;
            default:
                System.out.println("No idea What to Start");
        }
    }
}
