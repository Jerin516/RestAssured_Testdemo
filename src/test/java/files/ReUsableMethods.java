package files;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.path.json.JsonPath;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReUsableMethods {

public ExtentReports extent;
public static ExtentTest scenarioDef;
public static ExtentTest features;
public static  String reportLocation = "C:/Users/jerjose/Documents/RestAssured_Demo/";
static InputStream inputStream;
static String propFileName = "config.properties";


	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}

	
	public static String loadPropertiesFile(String attributeName) throws IOException {
		
		Properties prop = new Properties();
		

		inputStream = ReUsableMethods.class.getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		String val = prop.getProperty(attributeName);
		return val;
	}
	
	
	
	public static void setPropertiesFile(String attributeName, String val) throws IOException {
	
		Properties prop = new Properties();		
		prop.setProperty(attributeName, val);
	}
}
