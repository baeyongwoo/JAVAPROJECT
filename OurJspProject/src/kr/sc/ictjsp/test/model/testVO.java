package kr.sc.ictjsp.test.model;

//문제들 풀엇을 때 db에 저장
public class testVO {
	
	private String htmlQ;
	private String cssQ;
	private String javaQ;
	private String jspQ;
	
	public testVO() {}
	
	public testVO(String htmlQ, String cssQ, 
				String javaQ, String jspQ) {
		super();
		this.htmlQ = htmlQ;
		this.cssQ = cssQ;
		this.javaQ = javaQ;
		this.jspQ = jspQ;
	}

	public String getHtmlQ() {
		return htmlQ;
	}

	public void setHtmlQ(String htmlQ) {
		this.htmlQ = htmlQ;
	}

	public String getCssQ() {
		return cssQ;
	}

	public void setCssQ(String cssQ) {
		this.cssQ = cssQ;
	}

	public String getJavaQ() {
		return javaQ;
	}

	public void setJavaQ(String javaQ) {
		this.javaQ = javaQ;
	}

	public String getJspQ() {
		return jspQ;
	}

	public void setJspQ(String jspQ) {
		this.jspQ = jspQ;
	}

	@Override
	public String toString() {
		return "testVO [htmlQ=" + htmlQ + ", cssQ=" + cssQ + 
				", javaQ=" + javaQ + ", jspQ=" + jspQ + "]";
	}
	
	
	
	
	
}
