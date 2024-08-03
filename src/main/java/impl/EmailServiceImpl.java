package impl;

import javax.servlet.ServletContext;

import Service.EmailService;
import model.User;
import utils.SendEmailUtil;

public class EmailServiceImpl implements EmailService {
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Youtube Của Phúc";
	@Override
	public void SendEmail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String  port = context.getInitParameter("port");
		String  user = context.getInitParameter("user");
		String  pass = context.getInitParameter("pass");	
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear" + recipient.getUsername() + ", hope you have good time !"; 
				break;
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
