package kr.sc.ictjsp.tier.model;

public class TierVO {
	
	private int Unranked;
	private int Bronze;
	private int Silver;
	private int Gold;
	private int Platinum;
	private int Diamond;
	private int Ruby;

	public TierVO() {
		
	}
	
	public TierVO(int Unranked, int Bronze, int Silver,
			int Gold, int Platinum, int Diamond, int Ruby) {
		super();
		this.Unranked = Unranked;
		this.Bronze = Bronze;
		this.Silver = Silver;
		this.Gold = Gold;
		this.Platinum = Platinum;
		this.Diamond = Diamond;
		this.Ruby = Ruby;
	}

	public int getUnranked() {
		return Unranked = 1;
	}

	public void setUnranked(int unranked) {
		Unranked = unranked;
	}

	public int getBronze() {
		return Bronze = 2;
	}

	public void setBronze(int bronze) {
		Bronze = bronze;
	}

	public int getSilver() {
		return Silver = 3;
	}

	public void setSilver(int silver) {
		Silver = silver;
	}

	public int getGold() {
		return Gold = 4;
	}

	public void setGold(int gold) {
		Gold = gold;
	}

	public int getPlatinum() {
		return Platinum = 5;
	}

	public void setPlatinum(int platinum) {
		Platinum = platinum;
	}

	public int getDiamond() {
		return Diamond = 6;
	}

	public void setDiamond(int diamond) {
		Diamond = diamond;
	}

	public int getRuby() {
		return Ruby = 7;
	}

	public void setRuby(int ruby) {
		Ruby = ruby;
	}

	@Override
	public String toString() {
		return "TearVO [Unranked=" + Unranked + ", Bronze=" + Bronze + 
				", Silver=" + Silver + ", Gold=" + Gold	+ ", Platinum=" + 
				Platinum + ", Diamond=" + Diamond + ", Ruby=" + Ruby + "]";
	}
	
	
	
}


