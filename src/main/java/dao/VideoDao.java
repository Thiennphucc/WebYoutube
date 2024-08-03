package dao;

import java.util.List;

import model.video;

public interface VideoDao {
	video findById(Integer id);
	video findByHref(String Href);
	List <video> findAll();
	List <video> finAll(int pageNumber, int pageSize);
	video Create(video entity);
	video Update(video entity);
	video Delete(video entity);
}
