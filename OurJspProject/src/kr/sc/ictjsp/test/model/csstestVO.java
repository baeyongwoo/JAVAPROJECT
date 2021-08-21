package kr.sc.ictjsp.test.model;

public class csstestVO {

	private int testCode;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	
	public csstestVO() {}
	
	public csstestVO(int testCode, String answer1, String answer2,
			String answer3, String answer4, String answer5) {
		super();
		this.testCode = testCode;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
	}

	public int getTestCode() {
		return testCode;
	}

	public void setTestCode(int testCode) {
		this.testCode = testCode;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	@Override
	public String toString() {
		return "csstestVO [testCode=" + testCode + ", answer1=" + answer1 + 
				", answer2=" + answer2 + ", answer3="+ answer3 + ", answer4=" 
				+ answer4 + ", answer5=" + answer5 + "]";
	}

	
}
