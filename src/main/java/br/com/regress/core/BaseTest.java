package br.com.regress.core;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "http://reqres.in";
    }
}
