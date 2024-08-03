package dao.Impl;

import java.util.List;

import dao.AbstractDao;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao  {

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT o FROM User o WHERE o.username = ?0";
		return super.findOne(User.class, sql, username);		
		
	}

	@Override
	public User findByUsernameAndPassword(String password, String username) {
		String sql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, sql, username,password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pagenumber, int pagesize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pagenumber, pagesize);
	}
	
}
