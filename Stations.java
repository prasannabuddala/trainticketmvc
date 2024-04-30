package servlets;

public class Stations {
	private int stid;
	private String st_name;
	private String st_code;

	public Stations(int id, String name, String code) {
		this.stid = id;
		this.st_name = name;
		this.st_code = code;
	}

	public int getSt_id() {
		return stid;
	}

	public void setSt_id(int st_id) {
		this.stid = st_id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_code() {
		return st_code;
	}

	public void setSt_code(String st_code) {
		this.st_code = st_code;
	}

}
