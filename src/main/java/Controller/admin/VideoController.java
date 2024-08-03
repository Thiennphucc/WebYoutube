package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class VideoController
 */
@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoController() {
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
		String actionParam = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession session = request.getSession();
		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, request, response);
			break;
		}
		findAll(request, response);
	}

	protected void doGetWatch(HttpSession session, String href, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		video video = videoService.findByHref(href);
		request.setAttribute("video", video);
		request.setAttribute("main", "/Views/client/Components/youtube.jsp");
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);
	}
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<video> video = videoService.findAll();
		request.setAttribute("videos", video);
	}
}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 *      response)
 */
