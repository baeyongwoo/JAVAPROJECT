package kr.sc.ictjsp.users.model;

public class usersVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String birth;
	private String gender;
	
	public usersVO() {
		
	}
	
	public usersVO(String id, String pw, String name, 
				String email, String birth, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "UsersVO [id=" + id + ", pw=" + pw + ", name=" + name + 
				", email=" + email + ", birth=" + birth + ", gender=" + gender + "]";
	}

}
