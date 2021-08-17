package kr.sc.ictjsp.board.model;

import java.sql.Timestamp;

public class boardVO {
	
	private int no;
	private String choice;
	private String writer;
	private String title;
	private String content;
	private String age;
	private Timestamp writedate;
	private int hit;
	
	public boardVO() {
		
	}
	
	public boardVO(int no, String choice, String writer, String title,
			String content, String age, Timestamp writedate, int hit) {
		super();
		this.no = no;
		this.choice = choice;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.age = age;
		this.writedate = writedate;
		this.hit = hit;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "boardVO [no=" + no + ", choice=" + choice + ", writer=" + writer 
				+ ", title=" + title + ", content=" + content + ", age=" + age + 
				", writedate=" + writedate + ", hit=" + hit + "]";
	}

	
}
