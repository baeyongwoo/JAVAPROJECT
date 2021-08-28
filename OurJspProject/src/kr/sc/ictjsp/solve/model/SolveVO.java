package kr.sc.ictjsp.solve.model;

import java.sql.Timestamp;

public class SolveVO {
	private int id;	//db에 저장할 때 입력할때마다 생성
	private int tcode;		//문제 코드
	private String solve;	//답
	private Timestamp stime;
	private String suer;
	
	public SolveVO() {}

	public SolveVO(int id, int tcode, String solve, Timestamp stime, String suer) {
		super();
		this.id = id;
		this.tcode = tcode;
		this.solve = solve;
		this.stime = stime;
		this.suer = suer;
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

	public String getSolve() {
		return solve;
	}

	public void setSolve(String solve) {
		this.solve = solve;
	}

	public Timestamp getStime() {
		return stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

	public String getSuer() {
		return suer;
	}

	public void setSuer(String suer) {
		this.suer = suer;
	};
	
	

}
