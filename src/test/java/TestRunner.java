

import com.cucumber.listener.Reporter;

import Steps.RestUtils;
import Utilities.MonitoringMail;
import Utilities.RestAssuredExtention;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import files.ReUsableMethods;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty" }, features = "src//test//java//Features", glue = {
		"Steps" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:src/test/reports/cucumber_report.html",
				"html:output/html-report" }, monochrome = true)
public class TestRunner extends ReUsableMethods {
	
	@BeforeClass
	public static void setProperty()
	{
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'self'; script-src '*'; connect-src '*'; img-src '*'; style-src '*';");
	}
	
	@AfterClass
	public static void writeExtentReport() throws AddressException, MessagingException, UnknownHostException {
		Reporter.loadXMLConfig(new File("src//test//java//com//factory//cucumber//configuration//extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
		
		MonitoringMail mail = new MonitoringMail();
		String MessageBody = "http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/RestAssured_Testdemo/Extent_20Reports/";
	System.out.println(MessageBody);
	mail.sendMail(RestAssuredExtention.server, RestAssuredExtention.from, RestAssuredExtention.to, RestAssuredExtention.Subject, MessageBody);

	}
}

