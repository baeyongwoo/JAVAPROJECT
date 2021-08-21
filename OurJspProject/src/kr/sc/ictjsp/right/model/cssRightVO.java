package kr.sc.ictjsp.right.model;

public class cssRightVO {

	private int testcode;
	private String right1;
	private String right2;
	private String right3;
	private String right4;
	private String right5;
	
	public cssRightVO() {}
	
	public cssRightVO(int testcode, String right1, String right2, 
			String right3, String right4, String right5) {
		
		super();
		this.testcode = testcode;
		this.right1 = right1;
		this.right2 = right2;
		this.right3 = right3;
		this.right4 = right4;
		this.right5 = right5;
	}

	public int getTestcode() {
		return testcode;
	}

	public void setTestcode(int testcode) {
		this.testcode = testcode;
	}

	public String getRight1() {
		return right1;
	}

	public void setRight1(String right1) {
		this.right1 = right1;
	}

	public String getRight2() {
		return right2;
	}

	public void setRight2(String right2) {
		this.right2 = right2;
	}

	public String getRight3() {
		return right3;
	}

	public void setRight3(String right3) {
		this.right3 = right3;
	}

	public String getRight4() {
		return right4;
	}

	public void setRight4(String right4) {
		this.right4 = right4;
	}

	public String getRight5() {
		return right5;
	}

	public void setRight5(String right5) {
		this.right5 = right5;
	}

	@Override
	public String toString() {
		return "cssRightVO [testcode=" + testcode + ", right1=" + right1 + 
				", right2=" + right2 + ", right3=" + right3	+ ", right4="
				+ right4 + ", right5=" + right5 + "]";
	}

	
}
