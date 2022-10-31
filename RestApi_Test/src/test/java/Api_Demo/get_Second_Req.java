package Api_Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class get_Second_Req {

    public HashMap map = new HashMap();

    @BeforeClass
    public void uri_setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/user";
    }

    @BeforeClass
    public void genrateQueryParam() {
        map.put("page",utils.getpageNo());
    }

    @Test
    public void get_Rest() {

      given()
                .queryParams(map)// we put page and page no here replace of map
                .header("Content-Type", "application/json; charset=utf-8")// validate the content of header of particular page

                .when()
                    .get()

                .then()
                   .statusCode(200)// validate status code
                   .statusLine("HTTP/1.1 200 OK")
                   .log().all() //capture the complete output on the console window
                   .body("data[1].name", equalTo("chili pepper"))// validate response body the name of user on 2nd page is chili pepper
                   .assertThat().body("data[1].year", equalTo(2007))// we also use assertThat() with .body()
                   .body("data.name", contains("sand dollar", "chili pepper", "blue iris", "mimosa", "turquoise", "honeysuckle")) //multiple validation of user all name on 2nd page
                    .body("data.name",hasItems("mimosa","blue iris"))// multi validation
                   .body("support.url", equalTo("https://reqres.in/#support-heading"));
    }
}
