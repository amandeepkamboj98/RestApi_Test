package Api_Demo;

import io.restassured.RestAssured;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.rmi.CORBA.Util;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class post_First_req {

    public HashMap map = new HashMap();
    public String name;

    @BeforeClass
    public void uri_setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
    }

    @BeforeClass
    public void generateReqBody() {
      name=utils.getName();
        map.put("name",name);
        map.put("Job",utils.getJob());
    }

    @Test
    public void createUser(){
        given()
                .contentType("application/json") //required content is also pass file format
                .body(map)

                .when()
                   .post()

                .then()
                  .statusCode(201)
                .statusLine("HTTP/1.1 201 Created")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("name",equalTo(name))
                //.body("job",equalTo("HR"))

                .log().all()
    ;}

}
