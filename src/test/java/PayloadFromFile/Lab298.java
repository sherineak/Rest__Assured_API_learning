package PayloadFromFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class Lab298 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void testPostRequest(){
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        File file = new File("src/test/java/PayloadFromFile/postRequest.json");


        r.given();
        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(file  );

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);     // To verify the response in future

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

}

