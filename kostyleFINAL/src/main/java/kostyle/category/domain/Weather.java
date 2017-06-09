package kostyle.category.domain;

public class Weather {
	private double temp;
	private double wind_ms;
	private double vher;
	private double rainper;
	private String weather;
	
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getWind_ms() {
		return wind_ms;
	}
	public void setWind_ms(double wind_ms) {
		this.wind_ms = wind_ms;
	}
	public double getVher() {
		return vher;
	}
	public void setVher(double vher) {
		this.vher = vher;
	}
	public double getRainper() {
		return rainper;
	}
	public void setRainper(double rainper) {
		this.rainper = rainper;
	}
	public Weather(double temp, double wind_ms, double vher, double rainper, String weather) {
		super();
		this.temp = temp;
		this.wind_ms = wind_ms;
		this.vher = vher;
		this.rainper = rainper;
		this.weather = weather;
	}
	@Override
	public String toString() {
		return "Weather [temp=" + temp + ", wind_ms=" + wind_ms + ", vher=" + vher + ", rainper=" + rainper
				+ ", weather=" + weather + "]";
	}
	
	
	
}
