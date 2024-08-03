package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.HistoryService;
import Service.VideoService;
import constant.SessionAttr;
import impl.HistoryServiceImpl;
import impl.VideoServiceImpl;
import model.History;
import model.User;
import model.video;

@WebServlet(urlPatterns = {"/index","/history"})
public class ClientHomeServlet extends HttpServlet {
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/history": 
			doGetHistory(session, req,resp);
			break;
		}
		List<video> videos = videoService.findAll();
		req.setAttribute("main","/Views/client/Components/Index.jsp");
		req.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(req, resp);
	}
	private void doGetHistory(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findByUser(user.getUsername());
		List<video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		req.setAttribute("videos", videos);
		req.setAttribute("main","/Views/client/Components/History.jsp");
		req.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(req, resp);
	}
}
