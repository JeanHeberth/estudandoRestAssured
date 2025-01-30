package br.com.regress.test;

import br.com.regress.core.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

public class ReqresTest extends BaseTest {

    @Test
    public void validarStatusCodeDaListaDeUsuariosTest() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data", not(empty()))
                .body("data[0].id", greaterThan(0))
                .log().all();
    }

    @Test
    public void cruarUsuarioTest() {
        String requestBody = "{ \"name\": \"José\", \"job\": \"QA Engineer\" }";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("José"))
                .body("job", equalTo("QA Engineer"))
                .log().all();
    }

}
