package kr.sc.ictjsp.test.model;

//문제들 풀엇을 때 db에 저장
public class testVO {
	
	private String subject;
	private String questionNum;
	private String question;
	private String answer;
	
	public testVO() {}
	
	public testVO(String subject, String questionNum, 
				String question, String answer) {
		super();
		this.subject = subject;
		this.questionNum = questionNum;
		this.question = question;
		this.answer = answer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(String questionNum) {
		this.questionNum = questionNum;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "testVO [subject=" + subject + ", questionNum=" + questionNum + ", "
				+ "question=" + question + ", answer=" + answer + "]";
	}
}
