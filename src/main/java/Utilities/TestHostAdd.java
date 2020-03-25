package Utilities;

import java.lang.management.MonitorInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestHostAdd {

	
	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException
	{
		
		MonitoringMail mail = new MonitoringMail();
		String MessageBody = "http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/RestAssured_Testdemo/Extent_20Reports/";
	System.out.println(MessageBody);
	mail.sendMail(RestAssuredExtention.server, RestAssuredExtention.from, RestAssuredExtention.to, RestAssuredExtention.Subject, MessageBody);
	}
}
