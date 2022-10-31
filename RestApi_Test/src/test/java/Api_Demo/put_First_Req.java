package Api_Demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class put_First_Req {
    public HashMap map = new HashMap();

    @BeforeClass
    public void uri_configure(){
        int id=7;
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users"+id;
    }

    @BeforeClass
    public void map_Test(){
        map.put("name","morpheus");
        map.put("job","zion resident");
    }
}
