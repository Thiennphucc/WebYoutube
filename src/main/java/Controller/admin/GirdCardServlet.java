package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.VideoService;
import impl.VideoServiceImpl;
import model.video;

/**
 * Servlet implementation class GirdCardServlet
 */
@WebServlet("/GirdCardServlet")
public class GirdCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private	 VideoService videoService = new VideoServiceImpl();
    private static final int VIDEO_MAX_PAGE_SIZE = 8;
    /**pr
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<video> countVideo = videoService.findAll();
		int maxPage = (int)Math.ceil(countVideo.size()/(double) VIDEO_MAX_PAGE_SIZE); //countVideo.size() trả về số lượng video trong danh sách.
		request.setAttribute("maxPage", maxPage);
		String pageNumber = request.getParameter("page");
		List<video> videos;
		if(pageNumber == null) {
			videos = videoService.finAll(1, VIDEO_MAX_PAGE_SIZE);
			request.setAttribute("currentPage", 1);
		}else {
			videos = videoService.finAll(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
			request.setAttribute("currentPage", pageNumber);
		}
		request.setAttribute("videos", videos);
		System.out.println(videos);
		
		request.setAttribute("main","/Views/client/Components/GirdCard.jsp");
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
