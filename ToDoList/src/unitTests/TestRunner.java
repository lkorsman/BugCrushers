package unitTests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		// final String username = "";
		// final String password = "";

		StringBuilder sb = new StringBuilder();

		// Properties prop = new Properties();
		// prop.put("mail.smtp.host", "smtp.gmail.com");
		// prop.put("mail.smtp.port", "465");
		// prop.put("mail.smtp.auth", "true");
		// prop.put("mail.smtp.socketFactory.port", "465");
		// prop.put("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");

		Result result = JUnitCore.runClasses(ToDoElementStructTest.class);

		// Find all failed JUnit tests
		int i = 1;
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			sb.append(i + ". " + failure.toString() + "\n");
			i++;
		}
		System.out.println(result.wasSuccessful());

		// Generate email to send
		// if (!result.wasSuccessful()) {
		// Session session = Session.getInstance(prop,
		// new javax.mail.Authenticator() {
		// protected PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication(username, password);
		// }
		// });
		// try {
		// Message message = new MimeMessage(session);
		// message.setFrom(
		// new InternetAddress("lukekorsmanspam@gmail.com"));
		// message.setRecipients(
		// Message.RecipientType.TO,
		// InternetAddress.parse("lukekorsman@gmail.com"));
		// message.setSubject("ToDoListElementStructTest errors");
		// message.setText("Dear Manager,"
		// + "\n\nFailures found:\n" + sb.toString()
		// + "\n\nSincerely,\nThe Test Team");
		// Transport.send(message);
		// System.out.println("Done");
		// } catch (MessagingException e) {
		// e.printStackTrace();
		// }
		// }
	}
}
