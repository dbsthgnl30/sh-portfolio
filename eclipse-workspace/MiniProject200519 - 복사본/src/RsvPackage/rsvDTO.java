package RsvPackage;

import java.io.Serializable;

public class rsvDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	 ///hascode추가랑 toString 수정안함.
	
	             
	private String rsv_id;
	private String cus_id;
	private String mv_mvId;
	private String th_thId;
	private String day;
	private String rsvTime;
	private int num;
	private String paymentMethod;
	private int total;

	public rsvDTO() {
		// TODO Auto-generated constructor stub
	}

	public rsvDTO(String rsv_id, String cus_id, String mv_mvId, String th_thId, String day, String rsvTime, int num,
			String paymentMethod, int total) {
		super();
		this.rsv_id = rsv_id;
		this.cus_id = cus_id;
		this.mv_mvId = mv_mvId;
		this.th_thId = th_thId;
		this.day = day;
		this.rsvTime = rsvTime;
		this.num = num;
		this.paymentMethod = paymentMethod;
		this.total = total;
	}

	public String getRsv_id() {
		return rsv_id;
	}

	public void setRsv_id(String rsv_id) {
		this.rsv_id = rsv_id;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getMv_mvId() {
		return mv_mvId;
	}

	public void setMv_mvId(String mv_mvId) {
		this.mv_mvId = mv_mvId;
	}

	public String getTh_thId() {
		return th_thId;
	}

	public void setTh_thId(String th_thId) {
		this.th_thId = th_thId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRsvTime() {
		return rsvTime;
	}

	public void setRsvTime(String rsvTime) {
		this.rsvTime = rsvTime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rsv_id == null) ? 0 : rsv_id.hashCode());
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
		rsvDTO other = (rsvDTO) obj;
		if (rsv_id == null) {
			if (other.rsv_id != null)
				return false;
		} else if (!rsv_id.equals(other.rsv_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "rsvDTO [rsv_id=" + rsv_id + ", cus_id=" + cus_id + ", mv_mvId=" + mv_mvId + ", th_thId=" + th_thId
				+ ", day=" + day + ", rsvTime=" + rsvTime + ", num=" + num + ", paymentMethod=" + paymentMethod
				+ ", total=" + total + "]";
	}


	
	

	
	
}
