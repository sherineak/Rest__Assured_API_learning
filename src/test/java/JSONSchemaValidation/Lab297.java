package JSONSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab297 {
    @Test
    public void jsonValidation(){
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/2")
                .when().get().then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/JSONSchemaValidation/Schema.json")));

    }
}
