package Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import Service.UserService;
import constant.SessionAttr;
import impl.UserServiceImpl;
import model.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("main","/Views/client/Components/Login.jsp");
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        doPostLogin(session, request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void doPostLogin(HttpSession session ,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.login(username, password);
		 if(user != null) {
	            session.setAttribute(SessionAttr.CURRENT_USER, user);
	            resp.sendRedirect(req.getContextPath() + "/GirdCardServlet"); // Chuyển hướng đến trang index.jsp
	        } else {
	        	resp.sendRedirect(req.getContextPath() + "/LoginServlet"); // Chuyển hướng lại trang đăng nhập nếu không thành công
	        }
	}
	
	
}

