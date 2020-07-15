package MoviePackage;

import java.io.Serializable;

public class MovieDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mvId;
	private String title;
	private String dir;
	private String act;
	private String genre;
	private String age;
	private String playTime;
	
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieDTO(String mvId, String title, String dir, String act, String genre, String age, String playTime) {
		super();
		this.mvId = mvId;
		this.title = title;
		this.dir = dir;
		this.act = act;
		this.genre = genre;
		this.age = age;
		this.playTime = playTime;
	}

	public String getMvId() {
		return mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mvId == null) ? 0 : mvId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDTO other = (MovieDTO) obj;
		if (mvId == null) {
			if (other.mvId != null)
				return false;
		} else if (!mvId.equals(other.mvId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieDTO [영화아이디=" + mvId + ", 영화제목=" + title + ", 감독=" + dir + ", 배우=" + act + ", 장르=" + genre
				+ ", 관람등급=" + age + ", 러닝시간=" + playTime + "]";
	}
	
	
	
	
}
