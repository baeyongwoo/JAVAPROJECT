package kr.sc.ictjsp.users.model;

public class usersVO {
	
	private String uid;
	private String upw;
	private String uname;
	private String uemail;
	private String subject;
	private int htmlcount;
	private int csscount;
	private int javacount;
	private int jspcount;
	
	public usersVO() {}
	
	

	public usersVO(String uid, String upw, String uname, String uemail, String subject,
				int htmlcount, int csscount, int javacount, int jspcount) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.subject = subject;
		this.htmlcount = htmlcount;
		this.csscount = csscount;
		this.javacount = javacount;
		this.jspcount = jspcount;
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



	public int getHtmlcount() {
		return htmlcount;
	}



	public void setHtmlcount(int htmlcount) {
		this.htmlcount = htmlcount;
	}



	public int getCsscount() {
		return csscount;
	}



	public void setCsscount(int csscount) {
		this.csscount = csscount;
	}



	public int getJavacount() {
		return javacount;
	}



	public void setJavacount(int javacount) {
		this.javacount = javacount;
	}



	public int getJspcount() {
		return jspcount;
	}



	public void setJspcount(int jspcount) {
		this.jspcount = jspcount;
	}



	@Override
	public String toString() {
		return "usersVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + 
				", uemail=" + uemail + ", subject=" + subject + ", htmlcount=" +
				htmlcount + ", csscount=" + csscount + ", javacount=" + javacount + 
				", jspcount=" + jspcount + "]";
	}
}
