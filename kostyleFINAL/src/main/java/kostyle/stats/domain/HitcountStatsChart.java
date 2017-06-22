package kostyle.stats.domain;

public class HitcountStatsChart {
	private String cnt_date;
	private int seoul;
	private int busan;
	private int jeju;
	
	private int female;
	private int male;
	
	private int teen;
	private int twenty;
	private int thirty;
	
	public void HitcountStatsChart(){}

	public int getSeoul() {
		return seoul;
	}

	public void setSeoul(int seoul) {
		this.seoul = seoul;
	}

	public int getBusan() {
		return busan;
	}

	public void setBusan(int busan) {
		this.busan = busan;
	}

	public int getJeju() {
		return jeju;
	}

	public void setJeju(int jeju) {
		this.jeju = jeju;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getTeen() {
		return teen;
	}

	public void setTeen(int teen) {
		this.teen = teen;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getThirty() {
		return thirty;
	}

	public void setThirty(int thirty) {
		this.thirty = thirty;
	}

	public String getCnt_date() {
		return cnt_date;
	}

	public void setCnt_date(String cnt_date) {
		this.cnt_date = cnt_date;
	}
	
}
