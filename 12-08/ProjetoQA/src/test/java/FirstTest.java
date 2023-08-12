import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstTest {
    @Test
    public void teste01(){
        RestAssured.given().contentType(ContentType.JSON)
                .when().get("usuarios")
                .then().statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void teste02(){
        String id = "0uxuPY0cbmQhpEz1";

        RestAssured.given().contentType(ContentType.JSON)
                .when().get("usuarios/{id}", id)
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void teste03(){
        String id = "kWKvLB0f446JszyZ";

        RestAssured.given().contentType(ContentType.JSON)
                .when().delete("usuarios/{id}", id)
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void test04(){
        RestAssured.given().contentType(ContentType.JSON)
                .when().get("produtos")
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void teste05(){
        Login login = new Login("fulano@qa.com", "teste");
        RestAssured.given().contentType(ContentType.JSON)
                .body(login)
                .when().post("login")
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }

    @BeforeEach
    public void setUpTest(){
        RestAssured.baseURI = "https://serverest.dev/";
    }
}
