package miniproject;

public class CusDTO {
private String  id;
private String pwd;
private String name;
private String birthdate;
private String age;
private String tel;

public CusDTO() {
	// TODO Auto-generated constructor stub
}


public CusDTO(String id, String pwd, String name, String birthdate, String age, String tel) {
	super();
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.birthdate = birthdate;
	this.age = age;
	this.tel = tel;
}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBirthdate() {
	return birthdate;
}

public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
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
	CusDTO other = (CusDTO) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


@Override
public String toString() {
	return "로그인 되었습니다.";
}

}
