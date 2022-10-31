package Api_Demo;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class post_Second_Req {

    public FileInputStream file;

    @BeforeClass
    public void uri_setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
    }

    @BeforeClass
    public void getUser() throws FileNotFoundException {
      // file=new FileInputStream("E:\\RestApi_Test\\src\\test\\resources\\CreateUser_InputPayload.json");
        file=new FileInputStream(".\\src\\test\\resources\\CreateUser_InputPayload.json"); //relative path
    }

    @Test
    public void createUser(){
               given()
                       .contentType("application/json") //content type pass
                  .body(file)
                 // .body(IOUtils)
                .when()
                    .post()

                .then()
                   .statusCode(201)
                   .statusLine("HTTP/1.1 201 Created")
                   .header("Content-Type", "application/json; charset=utf-8")
                  // .body("name",equalTo("morpheus")) // we comment this name after we change data in json file


                   .log().all()
        ;}

}
