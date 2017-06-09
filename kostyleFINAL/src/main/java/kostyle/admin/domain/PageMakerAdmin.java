package kostyle.admin.domain;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMakerAdmin {

	  private int totalCount;//전체 글 수
	  private int startPage;//시작 페이지 번호
	  private int endPage;//마지막 페이지 번호
	  private boolean prev;//이전 버튼 boolean 값
	  private boolean next;//이후 버튼 boolean 값

	  private int displayPageNum = 10;//보여줄 페이지 개수

	  private CriteriaAdmin cri;

	  public void setCri(CriteriaAdmin cri) {
	    this.cri = cri;
	  }

	  public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;

	    calcData();
	  }

	  private void calcData() {
		  
		  //endPage = (현재 페이지 번호/보여줄 페이지 번호)*보여줄 페이지 개수
	    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
	    
	    //startPage = endPage - 보여줄 페이지 개수 +1
	    startPage = (endPage - displayPageNum) + 1;

	    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
	    //(전체 글 수/보여줄 페이지수)보다 endPage가 크면 endPage=tepmEndPage
	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }

	    //startPage=1이면 prev버튼은 false, 아니면 true
	    prev = startPage == 1 ? false : true;

	    //endPage*보여줄 페이지수 < 전제 글 수 면 true(=endPage 뒤에 글이 더 있으면)
	    next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	  }

	  public int getTotalCount() {
	    return totalCount;
	  }

	  public int getStartPage() {
	    return startPage;
	  }

	  public int getEndPage() {
	    return endPage;
	  }

	  public boolean isPrev() {
	    return prev;
	  }

	  public boolean isNext() {
	    return next;
	  }

	  public int getDisplayPageNum() {
	    return displayPageNum;
	  }

	  public CriteriaAdmin getCri() {
	    return cri;
	  }
	  
	  public String makeQuery(int page) {
		    UriComponents uriComponents = UriComponentsBuilder.newInstance()
		    		.queryParam("page", page)
		    		.build();
			//UriComponents: get 방식 uri를 추가할 수 있는 객체
		    //queryParam("query의 key", value): url의 key 값에 value를 넣어
		    //=page=page, perPageNum=보여줄 페이지 개수
		  
		    return uriComponents.toUriString();
		  }
	  
	  public String makeSearch(int page){
		    
		    UriComponents uriComponents =
		              UriComponentsBuilder.newInstance()
		              .queryParam("page", page)
		              .queryParam("searchType", ((SearchCriteriaAdmin)cri).getSearchType())
		              .queryParam("keyword", ((SearchCriteriaAdmin)cri).getKeyword())
		              .build();             
		    
		    return uriComponents.toUriString();
		  } 
		  
		  public String encoding(String keyword){
			  if(keyword == null || keyword.trim().length() == 0){//키워드가 빈칸이면 return ""
				  return "";
			  }
			  try {
				return URLEncoder.encode(keyword, "UTF-8");//빈칸이 아니면 인코딩
			} catch (Exception e) {
				return "";
			}
		  }
}
