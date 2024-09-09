package org.example.ex_1_restAssured;

import io.restassured.RestAssured;

public class Lab260 {
    public static void main(String[] args) {
        //Rest Assured Hello World program
        // Sample example for APi Automate using Given_When _then

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com").basePath("/ping")
                .when().get()
                .then().statusCode(201);


    }
}
