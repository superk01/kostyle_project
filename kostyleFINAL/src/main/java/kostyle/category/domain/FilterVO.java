package kostyle.category.domain;

public class FilterVO {
	private String keyword;
	private String filter;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public FilterVO(String keyword, String filter) {
		super();
		this.keyword = keyword;
		this.filter = filter;
	}
	@Override
	public String toString() {
		return "FilterVO [keyword=" + keyword + ", filter=" + filter + "]";
	}
	
	
}
