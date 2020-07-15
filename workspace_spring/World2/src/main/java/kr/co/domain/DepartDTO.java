package kr.co.domain;

public class DepartDTO {
private String did;
private String dname;
public DepartDTO() {
	// TODO Auto-generated constructor stub
}
public DepartDTO(String did, String dname) {
	super();
	this.did = did;
	this.dname = dname;
}
public String getDid() {
	return did;
}
public void setDid(String did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((did == null) ? 0 : did.hashCode());
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
	DepartDTO other = (DepartDTO) obj;
	if (did == null) {
		if (other.did != null)
			return false;
	} else if (!did.equals(other.did))
		return false;
	return true;
}
@Override
public String toString() {
	return "DepartDTO [did=" + did + "]";
}

}
