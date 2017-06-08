package kostyle.closet.persistence;

import java.util.HashMap;
import java.util.List;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;

public interface ClosetDAO {

//-----------------folder-----------------------
	//조회해온 옷장상품의 clo_num으로 clo_name얻어오기
	public String cloNumTocloName(Closet closet);
	
	//모든 '옷장'폴더를 리스트로 반환... navigation에 사용
	public List<Closet> closetList(String c_num);
	
	//사용자의 모든 옷장에 들어있는 상품들을 전부 출력
	public List<ClosetPrd> fullCloset(ClosetPrd closetPrd);

	//사용자가 선택한 옷장의 상품들만 출력
	public List<ClosetPrd> selectCloset(ClosetPrd closetPrd);

	//옷장폴더 추가
	public void insertCloset(Closet closet);
	
	//가장 큰 옷장번호 구하기. 폴더추가시 max(clo_num)+1로
	public int max_clo_num(String c_num);

	//폴더이름 수정
	public void updateCloset(Closet closet);

	//옷장폴더 삭제(해당옷장상품들 먼저 삭제 -> 옷장삭제)
	public void deleteSameCloset_prds(Closet closet);
	//옷장삭제
	public void deleteCloset(Closet closet);
	//삭제를 위해 c_num으로 clo_num 가져오기
	public List<Integer> cNumTocloNum(String c_num);

	
//-------------------prd------------------------------------------------------
	

	//찜상품추가
	public int insertClosetPrd(ClosetPrd closetPrd);
	
	//해당상품의 중복여부 우선확인
	public int check_duplication(ClosetPrd closetPrd);
	
	//가장 큰 clo_detail_num구하기. 찜상품추가시 +1해서 clo_detail_num으로사용
	public int max_detail_num();
	
	//해당상품zzim횟수 구하기 보완필요. 찜추가/삭제시 다른사람한테도 카운트반영되도록.
	public int count_zzim(ClosetPrd closetPrd);
	
	//(찜추가시)밑의 getImgURL,Price,Name 합쳐서 해시맵에.
	public HashMap urlRepair(String prdUrl);
	
	//찜상품 이미지url따오기
	public String getImgURL(String source);
	
	//찜상품 가격 가져오기
	public String getPrice(String source);
	
	//찜상품 이름 가져오기
	public String getPrdName(String source);
	
	//url에서 http://떼기
	public String prdUrlRepair(String prdUrl);
	
	//쇼핑몰 도메인 가져오기
	public String getShopUrl(String prdUrl);
	
	//꼭 DB로 해야하나.. 등록시 url로 쇼핑몰이름따오기
	public String getS_name(String closetPrd_shopUrl);
	
	
	
	//상품의 옷장(폴더)이동
	public void moveClosetPrd(ClosetPrd closetPrd);
	
	//상품 삭제
	public void deleteClosetPrd(int clo_detail_num);

	

	
}//class
