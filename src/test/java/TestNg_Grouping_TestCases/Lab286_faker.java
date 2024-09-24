package TestNg_Grouping_TestCases;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286_faker {
// Faker to generate random username and password

    @Test
   public void testDemo1(){
        Faker faker = new Faker();
        String username = faker.name().username();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println(username);
        System.out.println(phoneNumber);

    }



}
