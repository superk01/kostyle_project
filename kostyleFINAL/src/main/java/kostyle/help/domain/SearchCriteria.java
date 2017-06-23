package kostyle.help.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchCriteria extends Criteria {
	private String searchType;
	private String keyWord;
	private String c_Id;
	private String s_Num;
	
	public String getS_Num() {
		return s_Num;
	}
	public void setS_Num(String s_Num) {
		this.s_Num = s_Num;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getC_Id() {
		return c_Id;
	}
	public void setC_Id(String c_Id) {
		this.c_Id = c_Id;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyWord=" + keyWord + ", c_Id=" + c_Id + ", s_Num="
				+ s_Num + "]";
	}
	
	
}
