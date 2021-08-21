package kr.sc.ictjsp.correct.model;

public class correctVO {

	private int ccode;
	private String correct;
	public correctVO(int ccode, String correct) {
		super();
		this.ccode = ccode;
		this.correct = correct;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return "correctVO [ccode=" + ccode + ", correct=" + correct + "]";
	}
	
	
}
