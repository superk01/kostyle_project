package kostyle.coordinator.domain;

import org.springframework.web.multipart.MultipartFile;

public class CoordinatorVO {
	private String cd_name;
	private String s_num;
	private String s_name;
	private String cd_img;
	private String regdate;
	private String cd_like;
	private String prd_url1;
	private String prd_url2;
	private String prd_url3;
	private String cd_content;
	private MultipartFile uploadFile;
	
	
	public String getCd_content() {
		return cd_content;
	}
	public void setCd_content(String cd_content) {
		this.cd_content = cd_content;
	}
	
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getCd_img() {
		return cd_img;
	}
	public void setCd_img(String cd_img) {
		this.cd_img = cd_img;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCd_like() {
		return cd_like;
	}
	public void setCd_like(String cd_like) {
		this.cd_like = cd_like;
	}
	public String getPrd_url1() {
		return prd_url1;
	}
	public void setPrd_url1(String prd_url1) {
		this.prd_url1 = prd_url1;
	}
	public String getPrd_url2() {
		return prd_url2;
	}
	public void setPrd_url2(String prd_url2) {
		this.prd_url2 = prd_url2;
	}
	public String getPrd_url3() {
		return prd_url3;
	}
	public void setPrd_url3(String prd_url3) {
		this.prd_url3 = prd_url3;
	}
	/**
	 * @return the uploadFile
	 */
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoordinatorVO [cd_name=" + cd_name + ", s_num=" + s_num + ", s_name=" + s_name + ", cd_img=" + cd_img
				+ ", regdate=" + regdate + ", cd_like=" + cd_like + ", prd_url1=" + prd_url1 + ", prd_url2=" + prd_url2
				+ ", prd_url3=" + prd_url3 + ", cd_content=" + cd_content + ", uploadFile=" + uploadFile + "]";
	}
	
}
