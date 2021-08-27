package kr.sc.ictjsp.users.model;

public class usersVO {
	
	private String uid;
	private String upw;
	private String uname;
	private String uemail;
	private String subject;
	private int point;
	private int tier;
	
	public usersVO() {}
	
	

	public usersVO(String uid, String upw, String uname, 
			String uemail, String subject, int point, int tier) {
		
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.subject = subject;
		this.point = point;
		this.tier = tier;
		
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

	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}
	
	

	public int getTier() {
		return tier;
	}



	public void setTier(int tier) {
		this.tier = tier;
	}



	@Override
	public String toString() {
		return "usersVO [uid=" + uid + ", upw=" + upw + ", uname=" 
						+ uname + ", uemail=" + uemail + ", subject="
						+ subject + ", point=" + point + ", tier=" + tier + "]";
	}
}
