package Api_Demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class put_Second_Req {

    public FileInputStream file1;

    @BeforeClass
    public void uri_configure() {
      //  int id = 2;
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
    }

    @BeforeClass
    public void getRequestBody() throws FileNotFoundException {
        file1 = new FileInputStream(".\\src\\test\\resources\\updateUserReq.json"); //relative path

    }

    @Test
    public void put_User() {
        given()
                .contentType("application/json") //content type pass
                .body(file1)
                // .body(IOUtils)
                .when()
                .put()

                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
        .log().all();
    }
}