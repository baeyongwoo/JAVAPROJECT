package kr.sc.ictjsp.quest.model;

public class questVO {

	private int qcode;
	private String quest;
	
	public questVO(int qcode, String quest) {
		super();
		this.qcode = qcode;
		this.quest = quest;
	}
	
	public int getqcode() {
		return qcode;
	}
	public void setqcode(int qcode) {
		this.qcode = qcode;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	@Override
	public String toString() {
		return "questVO [qcode=" + qcode + ", quest=" + quest + "]";
	}
	
	
}
