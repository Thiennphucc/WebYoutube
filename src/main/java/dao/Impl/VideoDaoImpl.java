package dao.Impl;

import java.util.List;

import dao.AbstractDao;
import dao.VideoDao;
import model.video;
public class VideoDaoImpl extends AbstractDao<video> implements VideoDao {

	@Override
	public video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(video.class, id);
	}

	@Override
	public video findByHref(String href) {
		String sql = "SELECT o FROM video o WHERE o.href = ?0 ";
		return super.findOne(video.class, sql, href);
	}

	@Override
	public List<video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(video.class, true);
	}

	@Override
	public List<video> finAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(video.class, true, pageNumber, pageSize);
	}

	@Override
	public video Create(video entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	@Override
	public video Update(video entity) {
		return super.update(entity);
	
	}

	@Override
	public video Delete(video entity) {
		return super.delete(entity);
	}

}
