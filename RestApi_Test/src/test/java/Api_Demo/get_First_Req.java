package Api_Demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class get_First_Req {

    @Test
    public void get_Rest(){

        given()

            .when()
                        .get("https://reqres.in/api/users?page=2")

                .then()

                    .statusCode(200);
    }
}
