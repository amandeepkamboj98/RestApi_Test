package Api_Demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class get_XML_Req {

    @BeforeClass
    public void con_uri(){
        int id=7;
        RestAssured.baseURI="http://www.thomas-bayer.com/";
        RestAssured.basePath="/sqlrest/CUSTOMER/7";
    }

    @Test
    public void get_XML(){
        given()
                .contentType("application/xml") // validate the content of header of particular page


                .when()
                      .get()

                .then()
                     .statusCode(200)
                     //.statusLine("HTTP/1.1 200 OK")
                .log().all() //to see all the output on the console window
                .body("CUSTOMER.FIRSTNAME",equalTo("James"))
                //.body("CUSTOMER.ID",equalTo(7))
                .header("Content-Type", "application/xml");// validate the content of header of particular page
               // .body("CUSTOMER.text()",containsInAnyOrder(""));// to verify the multiple values
    }



}
