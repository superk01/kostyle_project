<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_history() {
		location.href = "listAction.history?c_num=7"
	}
	function fn_remocon() {
		location.href = "remoconAction.history?c_num=1"
	}
</script>
</head>
<body>
	<div class="wing_banner" id="wingBanner">
		<!-- 2017-02-17 cyn  스크롤 이벤트 발생시 .wing_fixed 넣어주세요 -->
		<!-- 최근 본 상품 -->
		<div class="wing_prd_wrap" id="wingRecentWrap" style="">
			<div class="hwrap">
				<!-- 2017-02-22 cyn 타이틀 영역 마크업 수정 -->
				<strong class="tit"> <a href="#" id="wingRecentCount"><span
						class="tx">최근 본 상품</span><span class="count">4</span><span
						class="ico"></span></a>
				</strong>
				<!-- //2017-02-22 cyn 타이틀 영역 마크업 수정 -->
			</div>
			<div class="wing_prd_list" id="windRecentPrdList">
				<ul id="wingRecentPrd_1" style="">
					<li class="wing_prd" id="136905537"><a
						href="http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&amp;prdNo=136905537"
						target="_blank"><span class="wing_prd_img"><img
								src="http://i.011st.com/t/080/pd/17/9/0/5/5/3/7/Mcipr/136905537_L300.jpg"
								alt="맥심 화이트 골드 320T / 모카"
								onerror="skp11.common.blankImage(this, 60);"></span><span
							class="wing_prd_info"><span class="p_name">맥심 화이트
									골드 320T / 모카</span><span class="p_price"><strong>31,900</strong>원~</span></span></a>
					<button type="button" class="wing_btn_delete" prdno="136905537">목록에서
							상품 삭제</button></li>
					<li class="wing_prd" id="19183325"><a
						href="http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&amp;prdNo=19183325"
						target="_blank"><span class="wing_prd_img"><img
								src="http://i.011st.com/t/080/pd/16/1/8/3/3/2/5/uVJDT/19183325_L300.jpg"
								alt="업계를 리드하는 기업 3sk 택"
								onerror="skp11.common.blankImage(this, 60);"></span><span
							class="wing_prd_info"><span class="p_name">업계를 리드하는
									기업 3sk 택</span><span class="p_price"><strong>27,900</strong>원</span></span></a>
					<button type="button" class="wing_btn_delete" prdno="19183325">목록에서
							상품 삭제</button></li>
				</ul>
				<ul id="wingRecentPrd_2" style="display: none;"></ul>
			</div>
			<div class="wing_paging">
				<!-- 2017-02-17 cyn 상품이 두 개 이하 존재할 경우 페이징 비노출 -->
				<div class="wing_btn">
					<button type="button" class="wing_btn_prev"
						id="wb_btn_recentPrd_prev">이전 상품 리스트</button>
					<button type="button" class="wing_btn_next"
						id="wb_btn_recentPrd_next">다음 상품 리스트</button>
				</div>
			</div>
			<!-- 최근 본 상품 레이어 -->
			<div class="wing_prd_layer">
				<!-- 2017-02-17 cyn 레이어 오픈시 .on 넣어주세요 -->
				<ul id="wingRecentPrdListLayer"></ul>
				<button type="button" class="wing_btn_close">최근 본 상품목록 닫기</button>
				<span class="wing_layer_tail"></span>
			</div>
			<!-- //최근 본 상품 레이어 -->
		</div>
		<!-- 최근 본 상품 -->
		<!-- 추천 상품 -->
		<div class="wing_prd_wrap wing_prd_wrap2">
			<div class="hwrap">
				<strong class="tit">추천상품</strong>
			</div>
			<div class="wing_prd_list" id="recommendPrdList">
				<ul>
					<li class="wing_prd" data-prdno="925741955"
						data-trcno="1201706134669468788" data-typecd="M" data-areacd="A02">
						<!-- 상품 --> <a
						href="http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&amp;prdNo=925741955"
						title="새창열기" target="_blank"> <span class="wing_prd_img"><img
								src="http://i.011st.com/ex_t/R/68x68/1/85/1/src/browsing/seller/2017/04/04/voralamp3/2017040417070401860.jpg"
								alt="빨래건조대의혁명! 빨래건조 "
								onerror="skp11.common.blankImage(this, 60);"></span>
						<!-- 2017-02-17 cyn alt에 상품명 넣어주세요. --> <span
							class="wing_prd_info"> <span class="p_name">빨래건조대의혁명!
									빨래건조 </span> <span class="p_price"><strong>10,900</strong>원~</span>
						</span>
					</a> <!-- //상품 -->
					</li>
				</ul>
			</div>
			<div class="ad_nwlay">
				<button type="button" class="ad_link" id="wingHelpPopBtn">
					광고<span class="ico"></span>
				</button>
				<div class="help_pop" style="display: none;" id="wingHelpPop">
					<p>11번가 판매자의 추천상품으로 추천상품 광고 아이템을 구매한 상품입니다.</p>
					<button type="button" class="btn_close" id="wingHelpPopCloseBtn">레이어
						닫기</button>
				</div>
			</div>
		</div>
		<!-- 추천 상품 -->
		<div class="wing_vis_area" id="dsLeftWingBannerMiddle">
			<a
				href="http://ds.11st.co.kr/click/11st/11st_main/main@2017_main_right?ads_id=42400&amp;creative_id=35837&amp;click_id=34361&amp;noCache=1497424339203"
				target="_blank"><img
				src="http://i.011st.com/ds/2017/06/03/977/ca2b310c1748fa91ee0bd046a5a68ed5.jpg"
				alt="HP이벤트" width="70" border="0" height="145"></a>
		</div>
		<div class="btn_top">
			<a href="#">
				<!-- 2017-02-17 main페이지 #wrap으로 이동, 서브페이지 #wrapBody로 이동--> <img
				src="http://s.011st.com/img/main/wing/img_top.gif" alt="페이지 상단으로 이동">
			</a>
		</div>
	</div>
</body>
</html>