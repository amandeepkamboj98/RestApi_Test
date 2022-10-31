package Create_User;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class get_User {
    private HashMap map=new HashMap();
@BeforeClass
    public void con_uri(){
    RestAssured.baseURI="https://reqres.in";
    RestAssured.basePath="/api/users";
}

@BeforeClass
    public void get_map(){
    map.put("page",2);
  }

  @Test
    public void user_Req(){

    given()
            .queryParams(map)
            .header("Content-Type", "application/json; charset=utf-8")

            .when()
            .get()

            .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .header("Content-Type", "application/json; charset=utf-8")
            .body("data[1].id",equalTo(8))
            .body("data[0].first_name",equalTo("Michael"))
            .log().all();


  }



}
