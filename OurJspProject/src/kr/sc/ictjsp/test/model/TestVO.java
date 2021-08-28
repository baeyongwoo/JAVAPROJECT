package kr.sc.ictjsp.test.model;

public class TestVO {

	private int id;
	private int tcode;
	String question;
	String correct;
	String s_user; // 문제 출제자
	
	public TestVO() {
		
	}
	
	public TestVO(int id, int tcode, String question, 
			String correct, String s_user) {
		
		super();
		this.id = id;
		this.tcode = tcode;
		this.question = question;
		this.correct = correct;
		this.s_user = s_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTcode() {
		return tcode;
	}

	public void setTcode(int tcode) {
		this.tcode = tcode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public String getS_user() {
		return s_user;
	}

	public void setS_user(String s_user) {
		this.s_user = s_user;
	}

	@Override
	public String toString() {
		return "TestVO [id=" + id + ", tcode=" + tcode + 
					", question=" + question + ", correct=" 
					+ correct + ", s_user=" + s_user + "]";
	}
	
	
	
}
