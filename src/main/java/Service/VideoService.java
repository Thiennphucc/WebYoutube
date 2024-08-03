package Service;

import java.util.List;

import model.video;

public interface VideoService {
	video findById(Integer id);
	video findByHref(String Href);
	List <video> findAll();
	List <video> finAll(int pageNumber, int pageSize);
	
	video Update(video entity);
	video Delete(String Href);
	video create(String title, String href,String poster,String description);
}
