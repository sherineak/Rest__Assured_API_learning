package TestNG_Learn;

import org.testng.annotations.*;

public class Lab264 {
    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
        System.out.println("Open Data base ");
        System.out.println("Read csv or excel ");
        System.out.println("Read txt/ env or property");

    }
    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }
    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }
    @AfterClass
    void demo7(){
        System.out.println("After Class");
    }
    @AfterTest
    void demo8(){
        System.out.println("After Test");
    }
    @AfterSuite
    void demo9(){
        System.out.println("After Quote");
        System.out.println("Close data base connection");
        System.out.println("Close all opened file");
    }

}
