package Service;

import java.util.List;

import model.User;

public interface UserService {
	User findbyId(Integer id);
	User findbyEmail(String email);
	User findbyUserName(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User>findAll();
	List<User>findAll(int pagenumber,int pagesize);
	User create(String username,String email, String password);
	User update(User entity);
	User delete(String username);

}
