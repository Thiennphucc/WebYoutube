package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@Table(name="video")
@NamedQuery(name="Video.findAll", query="SELECT v FROM video v")
public class video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;
	@Column(name = "href")
	private String href;
	@Column(name = "poster")
	private String poster;
	@Column(name = "shares")
	private int shares;
	@Column(name = "title")
	private String title;
	@Column(name = "`views`")
	private int views;
	@Column(name = "isActive")
	private Boolean isActive;
	public Boolean IsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="video")
	private List<History> histories;

	public video() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getShares() {
		return this.shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setVideo(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setVideo(null);

		return history;
	}

	

}