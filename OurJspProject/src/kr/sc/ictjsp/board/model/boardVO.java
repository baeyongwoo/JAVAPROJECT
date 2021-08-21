package kr.sc.ictjsp.board.model;

public class boardVO {
	
	private int no;
	private String btype;
	private String btitle;
	private String bwriter;
	private String bcontent;
	private int bhit;
		
	public boardVO() {
		
	}
	
	public boardVO(int no, String btype, String btitle, 
				String bwriter, String bcontent, int bhit) {
		super();
		this.no = no;
		this.btype = btype;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bcontent = bcontent;
		this.bhit = bhit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	@Override
	public String toString() {
		return "boardVO [no=" + no + ", btype=" + btype + ", btitle=" + btitle + 
				", bwriter=" + bwriter + ", bcontent=" + bcontent + "bhit=" + bhit + "]";
	}	
}
