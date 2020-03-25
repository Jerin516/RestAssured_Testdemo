package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtention {

    public static RequestSpecification Request;
    public static String server = "smtp.gmail.com";
    public static String from = "jerrin.jose516@gmail.com";
    public static String password = "Jerin@jerry1991";	
    public static String[] to= {"jerrin.jose516@gmail.com"};
    public static String Subject = "Extent Project Report ";

    public RestAssuredExtention()
    {
        RequestSpecBuilder builder = new RequestSpecBuilder().setBaseUri("http://localhost:8080/student");
    builder.setContentType(ContentType.JSON);
    RequestSpecification requestSpec = builder.build();
    Request = RestAssured.given().spec(requestSpec);
    }

    public  static void GetOpsWithPathParamaters(String url, Map<String,String> pathParams) throws URISyntaxException {
        Request.pathParams(pathParams);
        Request.get(new URI(url));
    }

    public static ResponseOptions<Response> GetOps(String url) throws URISyntaxException {
        try {
            return Request.get(new URI(url));
        }
        catch(Exception e)

        {
            System.out.println(e);
        }
        return null;
    }

    
    
}
