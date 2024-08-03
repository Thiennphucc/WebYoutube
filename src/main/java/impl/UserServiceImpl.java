package impl;

import java.util.List;

import Service.UserService;
import dao.UserDao;
import dao.Impl.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {
	private UserDao dao;
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	@Override
	public User findbyId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findbyEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User findbyUserName(String username) {
		// TODO Auto-generated method stub
		
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(password, username);
	}

	@Override
	public User resetPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pagenumber, int pagesize) {
		// TODO Auto-generated method stub
		return dao.findAll(pagenumber, pagesize);
	}

	@Override
	public User create(String username, String email, String password) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		entity.setIsActive(Boolean.TRUE);
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

}
