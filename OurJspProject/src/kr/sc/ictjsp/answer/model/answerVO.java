package kr.sc.ictjsp.answer.model;

public class answerVO {

	private int acode;
	private String answer;
	public answerVO(int acode, String answer) {
		super();
		this.acode = acode;
		this.answer = answer;
	}
	public int getAcode() {
		return acode;
	}
	public void setAcode(int acode) {
		this.acode = acode;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "answerVO [acode=" + acode + ", answer=" + answer + "]";
	}
	
	
}
