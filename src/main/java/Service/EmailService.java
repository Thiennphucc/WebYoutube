package Service;

import javax.servlet.ServletContext;

import model.User;

public interface EmailService {
	void SendEmail (ServletContext context,User recipient, String type);
	 
}
