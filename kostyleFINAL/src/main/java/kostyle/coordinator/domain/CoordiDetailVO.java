package kostyle.coordinator.domain;

public class CoordiDetailVO {
	private String cd_num;
	private String cdprd_num;
	private String prd_url;
	private String prd_img;
	
	public CoordiDetailVO(String cd_num, String prd_url, String prd_img) {
		super();
		this.cd_num = cd_num;
		this.prd_url = prd_url;
		this.prd_img = prd_img;
	}
	public String getCd_num() {
		return cd_num;
	}
	public void setCd_num(String cd_num) {
		this.cd_num = cd_num;
	}
	public String getCdprd_num() {
		return cdprd_num;
	}
	public void setCdprd_num(String cdprd_num) {
		this.cdprd_num = cdprd_num;
	}
	public String getPrd_url() {
		return prd_url;
	}
	public void setPrd_url(String prd_url) {
		this.prd_url = prd_url;
	}
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	@Override
	public String toString() {
		return "CoordiDetailVO [cd_num=" + cd_num + ", cdprd_num=" + cdprd_num + ", prd_url=" + prd_url + ", prd_img="
				+ prd_img + "]";
	}
	
}
