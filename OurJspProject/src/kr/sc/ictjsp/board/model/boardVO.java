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

	
	
}
