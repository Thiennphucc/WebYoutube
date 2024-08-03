package impl;

import java.util.List;

import Service.VideoService;
import dao.VideoDao;
import dao.Impl.VideoDaoImpl;
import model.video;

public class VideoServiceImpl implements VideoService {
	private VideoDao dao;
	
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();
	}
	@Override
	public video findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public video findByHref(String Href) {
		// TODO Auto-generated method stub
		return dao.findByHref(Href);
	}

	@Override
	public List<video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<video> finAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.finAll(pageNumber, pageSize);
	}

	@Override
	public video create(String title, String href,String poster, String description) {
		video newvideo = new video();
		newvideo.setTitle(title);
		newvideo.setHref(href);
		newvideo.setPoster(poster);
		newvideo.setViews(0);
		newvideo.setShares(0);
		newvideo.setDescription(description);
		newvideo.setIsActive(true);
		
		return dao.Create(newvideo);
	}
	@Override
	public video Update(video entity) {
		
		// TODO Auto-generated method stub
		return dao.Update(entity);
	}

	@Override
	public video Delete(String Href) {
		video entity = findByHref(Href);
		entity.setIsActive(Boolean.FALSE);
		return dao.Update(entity);
	}

}
