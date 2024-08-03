package dao;

import java.util.List;

import model.User;

public interface UserDao {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String password,String username);
	List<User>findAll();
	List<User>findAll(int pagenumber,int pagesize);

	User create(User entity);
	User update(User entity);
	User delete(User entity);
}
