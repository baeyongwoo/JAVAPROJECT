package kr.sc.ictjsp.solve.model;

import java.sql.Timestamp;

public class SolveVO {
	private int auto_acode;	//db에 저장할 때 입력할때마다 생성
	private int qcode;		//문제 코드
	private String answer;	//답
	private Timestamp solvedate;
	
	public SolveVO() {};
	
	public SolveVO(int auto_acode, int qcode, String answer, Timestamp solvedate) {
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
		return "SolveVO [auto_acode=" + auto_acode + ", qcode=" + qcode + ", answer=" + answer + ", solvedate="
				+ solvedate + "]";
	}
	

}
