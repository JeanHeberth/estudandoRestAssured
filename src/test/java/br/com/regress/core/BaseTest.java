package br.com.regress.core;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://reqres.in/api";
    }
}
