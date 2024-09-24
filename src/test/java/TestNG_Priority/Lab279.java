package TestNG_Priority;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Lab279 {
    @Test(priority = 1)
    public void testMethodB(){
        System.out.println("Test Method B");
    }
    @Test(priority = 2)
    public void testMethodC(){
        System.out.println("Test Method C");
    }
    @Test(priority = 0)
    public void testMethodA(){
        System.out.println("Test Method A");
    }
}
