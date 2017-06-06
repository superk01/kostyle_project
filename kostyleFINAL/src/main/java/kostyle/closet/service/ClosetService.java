package kostyle.closet.service;

import javax.servlet.http.HttpServletRequest;

public interface ClosetService {

	//뭔지 기억이..
	public void CDSessionAttribute();

	//처음 클릭해서 옷장에 들어왔을 때
	public void Closet(HttpServletRequest request);
	
	//옷장(폴더)전체추출
	public void TabCloset();

	//선택한 옷장만 보이게
	public void SelectCloest();
	
	//옷장변경저장(추가,이름수정,삭제 반영)
	public void SaveCloset();
/*	//옷장추가
	public void InsertCloset();
	
	//옷장수정
	public void UpdateCloset();

	//옷장삭제
	public void DeleteCloset();
*/

//---------------------------------------
	// 찜상품추가
	public void InsertPrd();
	
	//찜추가시 중복체크
	public void DuplicationCheckClosetPrd();


	//상품의 폴더이동
	public void MoveClosetPrd();


	//상품삭제
	public void DeleteClosetPrd();
	

	
}
