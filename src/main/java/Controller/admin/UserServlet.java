package Controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.User;

import Service.UserService;
import dao.UserDao;
import impl.UserServiceImpl;
import java.util.List; // Import List từ gói java.util

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/UserServlet/delete", "/UserServlet/edit", "/UserServlet/create",
		"/UserServlet/update" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl(); // Sử dụng tên thích hợp cho lớp UserService của bạn

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		if (url.contains("delete")) {
			DoDelete(request, response);
		} else if (url.contains("edit")) {
			DoEdit(request, response);

		} else if (url.contains("create")) {
			DoInsert(request, response);
		} else if (url.contains("update")) {
			DoUpdate(request, response);
		}
		request.setAttribute("main", "/Views/client/Components/user.jsp");
		findAll(request, response);
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> user = userService.findAll();
		request.setAttribute("users", user);
	}

	public void DoDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			userService.delete(id);
			request.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("error", "Xóa thất bại");
		}

	}

	public void DoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			User user = userService.findbyUserName(id);
			System.out.println(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void DoInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(username);
		try {
			userService.create(username, email, password);
			request.setAttribute("message", "Create Successly");

		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
			System.out.println(e);
		}

	}

	private void DoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			
			BeanUtils.populate(user, request.getParameterMap());
			userService.update(user);
			request.setAttribute("message", "Update Successly");
		} catch (IllegalAccessException | InvocationTargetException e) {
			request.setAttribute("error", "Error: " + e.getMessage());
			System.out.println(e.getMessage());
		}
		
	}

}
