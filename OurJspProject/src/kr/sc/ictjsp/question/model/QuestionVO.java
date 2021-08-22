package kr.sc.ictjsp.question.model;

public class QuestionVO {

	private int qcode;
	private String question;
	
	public QuestionVO(int qcode, String question) {
		super();
		this.qcode = qcode;
		this.question = question;
	}
	
	public int getqcode() {
		return qcode;
	}
	public void setqcode(int qcode) {
		this.qcode = qcode;
	}
	public String getquestion() {
		return question;
	}
	public void setquestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "questionVO [qcode=" + qcode + ", question=" + question + "]";
	}
	
	
}
