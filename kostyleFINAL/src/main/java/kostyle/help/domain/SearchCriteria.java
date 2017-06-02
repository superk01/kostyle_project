package kostyle.help.domain;

public class SearchCriteria extends Criteria {
	private String searchType;
	private String keyWord;
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
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyWord=" + keyWord + "]";
	}
	
	
}
