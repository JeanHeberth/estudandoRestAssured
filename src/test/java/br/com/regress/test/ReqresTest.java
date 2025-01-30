package br.com.regress.test;

import br.com.regress.core.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThan;

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
}
