package kr.sc.ictjsp.users.model;

public class usersVO {
	
	private String uid;
	private String upw;
	private String uname;
	private String uemail;
	private String subject;
	private int uqcode;
	private int upoint;
	private int utier;
	
	public usersVO() {}

	public usersVO(String uid, String upw, String uname, String uemail, String subject, int uqcode, int upoint,
			int utier) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.subject = subject;
		this.uqcode = uqcode;
		this.upoint = upoint;
		this.utier = utier;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getUqcode() {
		return uqcode;
	}

	public void setUqcode(int uqcode) {
		this.uqcode = uqcode;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	public int getUtier() {
		return utier;
	}

	public void setUtier(int utier) {
		this.utier = utier;
	}

	@Override
	public String toString() {
		return "usersVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uemail=" + uemail + ", subject="
				+ subject + ", uqcode=" + uqcode + ", upoint=" + upoint + ", utier=" + utier + "]";
	}
	
	

		
}
