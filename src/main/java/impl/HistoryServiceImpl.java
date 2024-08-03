package impl;

import java.sql.Timestamp;
import java.util.List;

import Service.HistoryService;
import Service.VideoService;
import dao.HistoryDao;
import dao.Impl.HistoryDaoImpl;
import model.History;
import model.User;
import model.video;

public class HistoryServiceImpl implements HistoryService {
	private HistoryDao dao;
	private VideoService videoService = new VideoServiceImpl();
	
	public void HistoryDaoImpl() {
		dao = new HistoryDaoImpl();
	}
	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		// TODO Auto-generated method stub
		return dao.findByUserAndIsLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userID, Integer videoID) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userID, videoID);
	}

	@Override
	public History create(User user, video video) {
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existHistory == null) {
			History history = new History();
			history.setUser(user);
			history.setVideo(video);
			history.setViewedDate(new Timestamp(System.currentTimeMillis()));
			history.setIsLiked(Boolean.FALSE);
			return dao.create(existHistory);
		}	
		return existHistory;
	}

	@Override
	public Boolean updateLikeOrUnLike(User user, String videoHref) {
		video video = videoService.findByHref(videoHref);
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existHistory.getIsLiked() == Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLiked(Boolean.FALSE);
		}
		History updateHistory = dao.update(existHistory);
		return updateHistory != null ? true : false;
	}
	
}
