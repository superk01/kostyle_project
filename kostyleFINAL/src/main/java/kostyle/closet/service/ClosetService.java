package kostyle.closet.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;

public interface ClosetService {

	/* 폴더설정 창 닫을때 session에서 제거이벤트. 열 때와비슷. */
	public List<Closet> cdSessionAttribute(HttpServletRequest request, Map<Object,Object> param);

	//처음 클릭해서 옷장에 들어왔을 때
//	public Map closet(HttpServletRequest request, Closet param);
	public Map closet(HttpServletRequest request, Map<Object,Object> param);
	
	//옷장(폴더)전체추출
	public void tabCloset(HttpServletRequest request, Map<Object,Object> param);

/*	//선택한 옷장만 보이게
	public void selectCloset(HttpServletRequest request);*/
	
	//옷장변경저장(추가,이름수정,삭제 반영)
	public void saveCloset(HttpServletRequest request, Map<Object,Object> param);
/*	//옷장추가
	public void InsertCloset();
	
	//옷장수정
	public void UpdateCloset();

	//옷장삭제
	public void DeleteCloset();
*/

//---------------------------------------
	// 찜상품추가
	public int insertPrd(HttpServletRequest request, Map<Object,Object> param);
	//상품추가시 실제적인 일하는 함수
	public ClosetPrd insertPrdSub(HttpServletRequest request, Map<Object,Object> param);
	
	//찜추가시 중복체크
	public int duplicationCheckClosetPrd(HttpServletRequest request, String prdUrl);


	//상품의 폴더이동
	public void moveClosetPrd(HttpServletRequest request, Map<Object,Object> param);


	//상품삭제
	public void deleteClosetPrd(HttpServletRequest request, Map<Object, Object> param);


	
}
