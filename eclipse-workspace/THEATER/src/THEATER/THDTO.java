package THEATER;

import java.io.Serializable;

public class THDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String thId;
	private  String thName;
	private  String thLocation;
	private  String  thTel;
	
	public THDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getThId() {
		return thId;
	}

	public void setThId(String thId) {
		this.thId = thId;
	}

	public String getThName() {
		return thName;
	}

	public void setThName(String thName) {
		this.thName = thName;
	}

	public String getThLocation() {
		return thLocation;
	}

	public void setThLocation(String thLocation) {
		this.thLocation = thLocation;
	}

	public String getThTel() {
		return thTel;
	}

	public void setThTel(String thTel) {
		this.thTel = thTel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public THDTO(String thId, String thName, String thLocation, String thTel) {
		super();
		this.thId = thId;
		this.thName = thName;
		this.thLocation = thLocation;
		this.thTel = thTel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((thId == null) ? 0 : thId.hashCode());
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
		THDTO other = (THDTO) obj;
		if (thId == null) {
			if (other.thId != null)
				return false;
		} else if (!thId.equals(other.thId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "THDTO [영화관아이디=" + thId + ", 영화관이름=" + thName + ", 영화관위치=" + thLocation + ", 영화관전화번호=" + thTel + "]";
	}

	
	
	
 
}
