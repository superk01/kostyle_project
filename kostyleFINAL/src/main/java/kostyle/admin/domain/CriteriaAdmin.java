package kostyle.admin.domain;

public class CriteriaAdmin {

	  private int page;
	  private int perPageNum;

	  public CriteriaAdmin() {
	    this.page = 1;//현재 페이지 번호
	    this.perPageNum = 20;//한 페이지당 보여줄 글 개수
	  }

	  public void setPage(int page) {

	    if (page <= 0) {
	      this.page = 1;
	      return;
	    }

	    this.page = page;
	  }

	  public void setPerPageNum(int perPageNum) {

	    if (perPageNum <= 0 || perPageNum > 100) {
	      this.perPageNum = 10;
	      return;
	    }

	    this.perPageNum = perPageNum;
	  }

	  public int getPage() {
	    return page;
	  }

	  // method for MyBatis SQL Mapper -
	  public int getPageStart() {//현재 페이지의 첫글번호 구하기

	    return (this.page - 1) * perPageNum;
	  }

	  // method for MyBatis SQL Mapper
	  public int getPerPageNum() {

	    return this.perPageNum;
	  }

	  @Override
	  public String toString() {
	    return "Criteria [page=" + page + ", "
	        + "perPageNum=" + perPageNum + "]";
	  }
}
