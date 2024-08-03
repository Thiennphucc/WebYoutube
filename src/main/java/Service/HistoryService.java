package Service;

import java.util.List;

import model.History;
import model.User;
import model.video;

public interface HistoryService {
	List<History> findByUser(String username);
	List<History> findByUserAndIsLiked(String username);
	History findByUserIdAndVideoId(Integer userID, Integer videoID);
	History create(User user, video video);
	Boolean updateLikeOrUnLike(User user, String videoHref);
}
