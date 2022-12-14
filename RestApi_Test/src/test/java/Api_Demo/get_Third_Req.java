package Api_Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class get_Third_Req {

    public HashMap map = new HashMap();

    @BeforeClass
    public void uri_setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/user";
    }

    @BeforeClass
    public void generateQueryParam() {
        map.put("page", utils.getpageNo());
    }

    @Test
    public void get_Rest() {
        Response response= given()//response is a interface to create a object response
                .queryParams(map)// we put page and page no here replace of map
                .header("Content-Type", "application/json; charset=utf-8")// validate the content of header of particular page

                .when()
                .get()

                .then()
                .statusCode(200)// validate status code
                .statusLine("HTTP/1.1 200 OK")
               // .log().all() //capture the complete lof of response generated by the request on console window
                .body("data[1].name", equalTo("chili pepper"))// validate response body the name of user on 2nd page is chili pepper
                .assertThat().body("data[1].year", equalTo(2007))// we also use assertThat() with .body()
                .body("data.name", contains("sand dollar", "chili pepper", "blue iris", "mimosa", "turquoise", "honeysuckle")) //multiple validation of user all name on 2nd pa
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .extract().response();// to see only response

             String responsebody=response.getBody().asString(); // convert response into String

        System.out.println(responsebody);
    }
}
