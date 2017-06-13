<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="board-foot">
		<div class="board-foot-search" data-role="view-search">
			<input id="viewSearchBoardCd" type="hidden" value="community">
			<!-- Tertiary Search Filter -->
			<div class="btn-group bootstrap-select select">
				<button title="통합검색" class="btn dropdown-toggle btn-default"
					aria-expanded="false" type="button" data-toggle="dropdown">
					<span class="filter-option pull-left">통합검색</span>&nbsp;<span
						class="bs-caret"><span class="caret"></span></span>
				</button>
				<div class="dropdown-menu open">
					<ul class="dropdown-menu inner" role="menu">
						<li class="selected" data-original-index="0"><a tabindex="0"
							data-tokens="null"><span class="text">통합검색</span><span
								class="glyphicon glyphicon-ok check-mark"></span></a></li>
						<li data-original-index="1"><a tabindex="0"
							data-tokens="null"><span class="text">작성자</span><span
								class="glyphicon glyphicon-ok check-mark"></span></a></li>
						<li data-original-index="2"><a tabindex="0"
							data-tokens="null"><span class="text">댓글작성자</span><span
								class="glyphicon glyphicon-ok check-mark"></span></a></li>
					</ul>
				</div>
				<select tabindex="-98" class="select"
					data-role="total-select-filter">
					<option value="search_board">통합검색</option>
					<option value="search_write">작성자</option>
					<option value="search_comment">댓글작성자</option>
				</select>
			</div>
			<input title="검색" class="search-input" type="text"
				placeholder="검색어를 입력하세요." data-role="total-input-keyword">
			<button class="button-md button-search" type="button"
				data-role="total-submit">
				<span class="fa fa-search"></span>
			</button>
		</div>
	</div>
</body>
</html>