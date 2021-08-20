package kr.sc.ictjsp.users.model;

public class usersVO {
	
	private String uid;
	private String upw;
	private String uname;
	private String uemail;
	private int subject;
	
	public usersVO(String uid, String upw, String uname, 
				String uemail, int subject) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.subject = subject;
	}

	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "UsersVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + 
				", uemail=" + uemail + ", subject" + subject + "]";
	}

}
