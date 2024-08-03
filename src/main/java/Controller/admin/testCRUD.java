package Controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Service.VideoService;
import impl.VideoServiceImpl;
import model.video;

/**
 * Servlet implementation class testCRUD
 */
@WebServlet({ "/testCRUD", "/testCRUD/delete", "/testCRUD/create", "/testCRUD/edit" ,"/testCRUD/update"})
public class testCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoService videoService = new VideoServiceImpl(); // Sử dụng tên thích hợp cho lớp UserService của bạn

    /**
     * @see HttpServlet#HttpServlet()
     */
    public testCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("edit")) {
			DoEdit(request, response);
		}else if (url.contains("create")) {
			doGetCreate(request, response);
			
		}else if (url.contains("delete")) {
			doGetDelete(request, response);
			
		}else if (url.contains("update")) {
			try {
				DoGetUpdate(request, response);
			} catch (IllegalAccessException | InvocationTargetException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		request.setAttribute("main", "/Views/client/Components/ManagerVideo.jsp");
		findAll(request, response);
		request.getRequestDispatcher("/Views/client/masterLayout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<video> videos = videoService.findAll();
		request.setAttribute("videos", videos);
	}
	public void DoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			video video = videoService.findByHref(id);
			request.setAttribute("video", video);
		} catch (Exception e) {

		}
	}
	public void doGetCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String href = request.getParameter("href");
		String poster = "https://img.youtube.com/vi/" + href + "/maxresdefault.jpg";
		String description = request.getParameter("description");
		try {
			video video = videoService.create(title, href, poster, description);
			request.setAttribute("message", "Create successfully!!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
			System.out.println(e);
		}

	}
	public void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			videoService.Delete(id);
			request.setAttribute("message", "Delete successfully!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	private void DoGetUpdate(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException{
		video video = new video();
		video.setIsActive(true);
		video.setPoster("https://img.youtube.com/vi/"+req.getParameter("href")+"/maxresdefault.jpg");
		BeanUtils.populate(video, req.getParameterMap());
		System.out.println(video.toString());
	
		System.out.println(req.getParameter("id"));	
		videoService.Update(video);
		req.setAttribute("message", "Delete successfully!!");
	}

}
