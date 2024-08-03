package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Service.EmailService;
import Service.UserService;
import constant.SessionAttr;
import impl.EmailServiceImpl;
import impl.UserServiceImpl;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl(); //khởi tạo một đối tượng của lớp UserServiceImpl và gán nó cho một biến có kiểu dữ liệu là UserService
	EmailService emailService = new EmailServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		request.setAttribute("main", "/Views/client/Components/Register.jsp");
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        doPostRegister(session, request, response);
	}

	private void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username = request.getParameter("username");			//lấy giá trị của tham số "username" từ request

			String password = request.getParameter("password");			//lấy giá trị của tham số "password" từ request

			String email = request.getParameter("email");			//lấy giá trị của tham số "email" từ request

			System.out.println(username);
			System.out.println(password);
			System.out.println(email);
			User user = userService.create(username, email, password); //tạo mới một đối tượng User trong cơ sở dữ liệu dựa trên các thông tin đăng ký mà người dùng đã cung cấp.
			
			if(user != null) {
				emailService.SendEmail(getServletContext(), user, "welcome");
	            session.setAttribute(SessionAttr.CURRENT_USER, user);
	            response.sendRedirect(request.getContextPath() + "/GirdCardServlet"); // Chuyển hướng đến trang index.jsp
	        } else {
	        	response.sendRedirect(request.getContextPath() + "/RegisterServlet"); // Chuyển hướng lại trang đăng nhập nếu không thành công
	        }
		}
}

