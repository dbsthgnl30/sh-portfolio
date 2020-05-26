package mini;



public class rsvDTO {
	private String id;
	private String name;
	private String title;
	private String theater;
	private String day;
	private int howmany;
	private int cost;
	private String seatNumber;
	
	public rsvDTO() {
		// TODO Auto-generated constructor stub
	}

	public rsvDTO(String id, String name, String title, String theater, String day, int howmany, int cost,
			String seatNumber) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.theater = theater;
		this.day = day;
		this.howmany = howmany;
		this.cost = cost;
		this.seatNumber = seatNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getHowmany() {
		return howmany;
	}

	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "예약되었습니다.";
	}

}
