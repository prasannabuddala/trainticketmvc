package servlets;

public class Trains {
	private int trid;
	private String trname;

	public Trains(int trid, String trname) {
		super();
		this.trid = trid;
		this.trname = trname;
	}

	public int getTrid() {
		return trid;
	}

	public void setTrid(int trid) {
		this.trid = trid;
	}

	public String getTrname() {
		return trname;
	}

	public void setTrname(String trname) {
		this.trname = trname;
	}

}
