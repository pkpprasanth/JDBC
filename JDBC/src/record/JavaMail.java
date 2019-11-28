package record;

import java.net.Authenticator;
import java.net.Inet4Address;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.management.MBeanException;

public class JavaMail {
	public static <Session> void sentmail(String recepient, String OTP)  {
		System.out.print("Prepring to send OTP to given email addresss\n");
		Properties properties = new Properties();//used to configure the properties for the mail
		/*
		 * mail.smtp.auth//an Authentication is needed for a email server will be defined by mail.smtp.auth
		 * mail.smtp.starttls.enable//this for tls ecryption
		 * host and port number for the email address 
		 * mail.smtp.host
		 * mail.smtp.port
		 * 
		 * */
		/*
		 * Warning: properties should be provided in only string values 
		 * 
		 * */
		properties.put("mail.smtp.auth", "true");//true indicated it requires a authentication 
		properties.put("mail.smtp.starttls.enable", "true");//true indicated tls encryption
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		//account details username and passowrd
		String myAccountEmail = "bindubs.216@gmail.com";
		String myAccountPassword =  "keshava06";
		Session session = Session.getInstance(properties,new Authenticator() {
			/*
			 * Authentication for username and password
			 * 
			 * */
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, myAccountPassword);
			}
		});
		Message message = prepareMessage(session, myAccountEmail, recepient, OTP);
		Transport.send(message);
		System.out.print("OTP to mail sent succesfully\n");
	}
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String OTP) throws MBeanException {
		// TODO Auto-generated method stub
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new Inet4Address(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Welcome to CorporateWelfareEmployee project");
			message.setText("Your otp is"+OTP);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
