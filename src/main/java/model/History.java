package model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@Table(name="history")
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "isLiked")
	private boolean isLiked;
	@Column(name = "likeDate")
	private Timestamp likedDate;
	@Column(name = "viewedDate")
	@CreationTimestamp
	private Timestamp viewedDate;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userID", referencedColumnName = "id")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoID",referencedColumnName = "id")
	private video video;

	public History() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsLiked() {
		return this.isLiked;
	}

	public void setIsLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikedDate() {
		return this.likedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		this.likedDate = likedDate;
	}

	public Timestamp getViewedDate() {
		return this.viewedDate;
	}

	public void setViewedDate(Timestamp viewedDate) {
		this.viewedDate = viewedDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public video getVideo() {
		return this.video;
	}

	public void setVideo(video video) {
		this.video = video;
	}

}