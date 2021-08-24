package kr.sc.ictjsp.answer.model;

import java.sql.Timestamp;

public class AnswerVO {

	private int auto_acode;
	private int qcode;
	private String answer;
	private Timestamp solvedate;
	
	
	
	public AnswerVO() {
		
	}
	
	public AnswerVO(int auto_acode, int qcode,  
			String answer, Timestamp solvedate) {
		super();
		this.auto_acode = auto_acode;
		this.qcode = qcode;
		this.answer = answer;
		this.solvedate = solvedate;
	}

	public int getAuto_acode() {
		return auto_acode;
	}

	public void setAuto_acode(int auto_acode) {
		this.auto_acode = auto_acode;
	}

	public int getQcode() {
		return qcode;
	}

	public void setQcode(int qcode) {
		this.qcode = qcode;
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
		return "AnswerVO [auto_acode=" + auto_acode + ", qcode=" + qcode 
				+ ", answer=" + answer + ", solvedate=" + solvedate + "]";
	}	
}
