package CRUD_Operation.GET.NonBDD_Style;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {
    /*
     Non BDD Style
     There is Rest Assured Automatically provided interface is Request Specification for Client Request
     and Response Specification for Server Response
    */
    RequestSpecification rs = RestAssured.given();
    @Test
    public void getRequestNonBDDStyle(){

        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/682307");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }
    @Test
    public void getRequestNonBDDStyle2(){

        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/682307");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }
}
