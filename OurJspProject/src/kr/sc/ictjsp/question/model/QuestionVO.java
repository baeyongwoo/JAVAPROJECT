package kr.sc.ictjsp.question.model;

public class QuestionVO {

	private int qcode;
	private String question;
	private int qtcount;
	
	public QuestionVO() {
		
	}
	
	public QuestionVO(int qcode, String question,
			int qtcount) {
		super();
		this.qcode = qcode;
		this.question = question;
		this.qtcount = qtcount;
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
	
	public int getQtcount() {
		return qtcount;
	}

	public void setQtcount(int qtcount) {
		this.qtcount = qtcount;
	}

	public void setquestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "questionVO [qcode=" + qcode +", qtcount=" +
				qtcount + ", question=" + question + "]";
	}
}