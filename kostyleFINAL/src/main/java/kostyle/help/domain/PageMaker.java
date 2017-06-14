package kostyle.help.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sun.media.jfxmedia.track.Track.Encoding;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 3;
	
	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void calcData() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum +1;

		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage>tempEndPage){
			endPage=tempEndPage;
		}
		
		prev = (startPage==1)?false:true;
		next = (endPage>=tempEndPage)?false:true;
		//원래 책에는
		/*next = endPage*cri.getPerPageNum() >= totalCount ? false: true;*/
	}
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
									  .queryParam("perPageNum", cri.getPerPageNum())
									  .queryParam("searchType", ((SearchCriteria) cri).getSearchType())
									  .queryParam("keyWord", ((SearchCriteria) cri).getKeyWord()).build();
		return uriComponents.toUriString();
		
	}
	public String encoding(String keyWord){
		if(keyWord==null||keyWord.trim().length()==0){
			return "";
		}
		try {
			return URLEncoder.encode(keyWord, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
		
	}
	

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	/*public static void main(String[] args) {
		PageMaker maker = new PageMaker();
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyWord("한글");
		maker.setCri(cri);
		
		String str = maker.makeSearch(2);
		System.out.println(str);
	}*/
	
}
