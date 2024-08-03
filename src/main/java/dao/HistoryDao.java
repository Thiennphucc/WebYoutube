package dao;

import java.util.List;

import model.History;

public interface HistoryDao {
	List<History> findByUser(String username);
	List<History> findByUserAndIsLiked (String username);
	History findByUserIdAndVideoId (Integer userID, Integer videoID);
	History create (History entity);
	History update (History entity);
}
