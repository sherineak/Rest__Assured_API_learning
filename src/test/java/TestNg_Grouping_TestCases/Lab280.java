package TestNg_Grouping_TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class Lab280 {
    //Grouping of testcases
    //100 test cases ,  20 testcases under P0, 30 testcases under P1, 50 Testcases under P3
    // 40 is Smoke testing , 60 is Sanity
    @Link(name = "Website", url ="https://google.com")
    @Issue("Auth 233")
    @Description("test case1")
    @Test(groups = {"Smoke"}, priority = 1)
    public void SmokeRun(){
        System.out.println("Smoke");
    }
    @Test(groups ={ "Sanity"},priority = 2)
    public void SanityRun(){
        System.out.println("Sanity");
    }

    @Test(groups = {"QA","Prod"})
    public void QARun(){
        System.out.println("QA");
    }

    @Test(groups = {"Prod"})
    public void ProdRun(){
        System.out.println("Production");
    }
}
