package kr.sc.ictjsp.answer.model;

import java.sql.Timestamp;

public class AnswerVO {

	private int acode;
	private int accacode;
	private String answeruid;
	private String answer;
	private Timestamp solvedate;
	
	
	
	public AnswerVO() {
		
	}
	
	public AnswerVO(int acode, int accacode, String answeruid, 
					String answer, Timestamp solvedate) {
		super();
		this.acode = acode;
		this.accacode = accacode;
		this.answeruid = answeruid;
		this.answer = answer;
		this.solvedate = solvedate;
	}

	public int getAcode() {
		return acode;
	}

	public void setAcode(int acode) {
		this.acode = acode;
	}

	public int getAccacode() {
		return accacode;
	}

	public void setAccacode(int accacode) {
		this.accacode = accacode;
	}

	public String getAnuid() {
		return answeruid;
	}

	public void setAnuid(String answeruid) {
		this.answeruid = answeruid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getSolvedate() {
		return solvedate;
	}

	public void setSolvedate(Timestamp solvedate) {
		this.solvedate = solvedate;
	}

	@Override
	public String toString() {
		return "AnswerVO [acode=" + acode + ", accacode=" + accacode + ", answeruid=" 
					+ answeruid + ", answer=" + answer + ", solvedate=" + solvedate + "]";
	}
	
	
	
}
