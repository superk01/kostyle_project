package kostyle.favorite.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class FavoritePageMaker {

  private int totalCount;
  private int startPage;
  private int endPage;
  private boolean prev;
  private boolean next;

  private int displayPageNum = 6;//보여지는 페이지번호의 갯수

  private FavoriteCriteria cri;

  public void setCri(FavoriteCriteria cri) {
    this.cri = cri;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;

    calcData();
  }

  private void calcData() {

    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

    startPage = (endPage - displayPageNum) + 1;

    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

    if (endPage > tempEndPage) {
      endPage = tempEndPage;
    }

    prev = startPage == 1 ? false : true;

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

  public FavoriteCriteria getCri() {
    return cri;
  }

@Override
public String toString() {
	return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
			+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
}

  
  
public String makeQuery(int page) {

    UriComponents uriComponents = UriComponentsBuilder.newInstance()
    		.queryParam("page", page)
    		.queryParam("perPageNum", cri.getPerPageNum())
    		.build();

    return uriComponents.toUriString();
}
  
  
 /*public String makeSearch(int page){
    
    UriComponents uriComponents =
              UriComponentsBuilder.newInstance()
              .queryParam("page", page)
              .queryParam("perPageNum", cri.getPerPageNum())
              .queryParam("searchType", ((FavoriteSearchCriteria)cri).getSearchType())
              .queryParam("keyword", ((FavoriteSearchCriteria)cri).getKeyword())
              .build();             
    
    return uriComponents.toUriString();
  } */
}