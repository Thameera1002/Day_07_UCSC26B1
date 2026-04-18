package com.api;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

public class APITest {
    private String token;

    @BeforeClass
    public void setup(){
        baseURI = "https://qa-library.zeoit.com/api/";

        String credentials = "{\n" +
                "  \"email\": \"super@admin.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}";

        token = given()
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        System.out.println(token);
    }

    @Test
    public void authAdmin(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("auth/me")
                .then()
                .statusCode(200)
                .body("data.email",org.hamcrest.Matchers.equalTo("super@admin.com"))
                ;

    }
}
