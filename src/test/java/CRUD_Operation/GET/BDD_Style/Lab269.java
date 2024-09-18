package CRUD_Operation.GET.BDD_Style;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab269 {
    // GET Method
    // Base Url =  https://api.zippopotam.us
    //Base Path= /IN/682307
    // AUTH  - Basic , Digest , BWT , Bearer Token, OAuth 2.0 ? = 0
    // Payload  - ? No for GET method


    // Verification
    //-->Status Code
    // -->Response Body
    // -->Time, Headers, Cookies


    //BDD Style - Given , When , Then
    @Test
    public void getRequestBDDStyle(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/682307")

                .when().log().all().get()

                .then().log().all().statusCode(200);

    }
}
