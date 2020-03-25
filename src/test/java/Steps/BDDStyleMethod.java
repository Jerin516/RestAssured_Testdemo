package Steps;


import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import Reporting.Log;

import java.io.IOException;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BDDStyleMethod {

    public static HashMap map = new HashMap();
    public static  String  placeId;
    public static String  keyVal;
    public static String baseURI;



    public static void setQueryParameters() throws IOException {
    	if(System.getenv("baseURI")!=null && !System.getenv("baseURI").isEmpty())
    	{
    		
    		RestAssured.baseURI=System.getenv("baseURI");
    	}
    	else
    		
    	{
    		 RestAssured.baseURI= ReUsableMethods.loadPropertiesFile("baseURI");
    	}
    	
    ReUsableMethods.setPropertiesFile("baseURI", RestAssured.baseURI);
    	
        keyVal = ReUsableMethods.loadPropertiesFile("key");
        Log.info("The Query Parameters are set" + ":"  + RestAssured.baseURI +keyVal );
    }

    public static void getData() throws IOException {
        Log.info("GETTING THE JSON FILE");
        given().log().all().queryParam("key", keyVal)
                .when().get(RestAssured.baseURI+ReUsableMethods.loadPropertiesFile("getBasePath"))
                .then().log().all();

    }
    public static void verifyStatusCode(String val) throws IOException {
        given().log().all().queryParam("key", keyVal)
                .when().get(RestAssured.baseURI+RestAssured.basePath)
                .then().assertThat().log().all().statusCode(200);
        Log.info("Verified the status code" + val);
    }


    public static void postData() throws IOException {
        map.put("AddPlace", RestUtils.AddPlace());
        RestAssured.baseURI= ReUsableMethods.loadPropertiesFile("baseURI");
        String response =    given().log().all().queryParam("key", keyVal).header("Content-Type","application/json")
                .body(RestUtils.AddPlace())
                .when().post(ReUsableMethods.loadPropertiesFile("basePath"))
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
        JsonPath js=new JsonPath(response);
        placeId  =js.getString("place_id");
        Log.info("Posted New Address in Google Map API");

    }

    public static void verifyGetData(String Address) throws IOException {
        String getPlaceResponse=	given().log().all().queryParam("key", keyVal)
                .queryParam("place_id",placeId)
                .when().get(ReUsableMethods.loadPropertiesFile("getBasePath"))
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1= ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress =js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, Address);

    }
    public static void updateData(String newAddress , String StatusMsg) throws IOException {
        //Update Place

        given().log().all().queryParam("key", keyVal).header("Content-Type","application/json")
                .body("{\r\n" +
                        "\"place_id\":\""+placeId+"\",\r\n" +
                        "\"address\":\""+newAddress+"\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}").
                when().put(ReUsableMethods.loadPropertiesFile("updateBasePath"))
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo(StatusMsg));

    }



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////*************************///////////////////////////////////////////////////
    public static void SimpleGetPost(String ListNumber, String attributeName, String attributeVal) {
        given()
                .when().get(String.format("http://localhost:8080/student/%s", ListNumber))
                .then().statusCode(200).statusLine("HTTP/1.1 200 ").assertThat().body(attributeName, equalTo(attributeVal));

        System.out.println(attributeName + " : " + attributeVal);
    }

    public static void SampleGetPost(String attributeVal)
    {


        given().
                when().
                get("http://dummy.restapiexample.com/api/v1/employees").
                then().
                assertThat().
                statusCode(200).and().log().all().
                body("data.employee_name", hasItems(attributeVal));




    }

    public static void SamplePostData(String basePath) {
        map.put("name",RestUtils.getEmployee_Name());
        map.put("salary" , RestUtils.getEmployee_Salary());
        map.put("age", RestUtils.getEmployee_Age());

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = basePath;

    }


    public static void testPost()
    {
        given().contentType("application/json").body(map)
                .when()
                .post()
                .then().statusCode(200)
                .and().body("status",equalTo("success")).contentType("application/json").log().all().extract().response();

    }


    public static void SamplePutData(String basePath) {
        map.put("name","Tiger Nixon");
        map.put("salary" , "320800");
        map.put("age", "62");
        int id =719;
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = basePath+id;

    }

    public static void SampleTestPut() {
        given().contentType("application/json").body(map)
                .when()
                .put()
                .then().statusCode(200)
                .log().all();

    }



}
