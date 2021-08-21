package kr.sc.ictjsp.right.model;

public class rightVO {
	
	private String htmlA;
	private String cssA;
	private String javaA;
	private String jspA;
	
	public rightVO() {}
	
	public rightVO(String htmlA, String cssA, 
			String javaA, String jspA) {
		super();
		this.htmlA = htmlA;
		this.cssA = cssA;
		this.javaA = javaA;
		this.jspA = jspA;
	}

	public String getHtmlA() {
		return htmlA;
	}

	public void setHtmlA(String htmlA) {
		this.htmlA = htmlA;
	}

	public String getCssA() {
		return cssA;
	}

	public void setCssA(String cssA) {
		this.cssA = cssA;
	}

	public String getJavaA() {
		return javaA;
	}

	public void setJavaA(String javaA) {
		this.javaA = javaA;
	}

	public String getJspA() {
		return jspA;
	}

	public void setJspA(String jspA) {
		this.jspA = jspA;
	}

	@Override
	public String toString() {
		return "rightVO [htmlA=" + htmlA + ", cssA=" + cssA + 
				", javaA=" + javaA + ", jspA=" + jspA + "]";
	}
	
	
	
	//html, css, java, jsp 
	//html의 코드 1~10
	//css의 코드는 11~20
	//java의 코드는 21~30
	//jsp의 코드는 31~40
	//.....
	
}
