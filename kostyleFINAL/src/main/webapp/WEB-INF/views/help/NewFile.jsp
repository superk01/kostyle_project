<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="nav-container">
		<div class="container post-container">

			<div class="content">
				<div class="board-subject">
					<!-- Board Head Region -->
					<div class="board-head">
						<ul>
							<li class="board-title"><span class="board-icon">f</span> <a
								href="/service/board/park">모두의공원</a></li>
						</ul>
					</div>
				</div>

				<form id="boardRegistForm" onsubmit="return false;">
					<!-- Post Title Region -->
					<div class="post-title">
						<input name="subject" class="new-post-title" type="text"
							placeholder="제목을 입력해 주세요" value="">
					</div>


					<!-- Post Editor Region -->
					<div class="fr-edit">
						<div class="loading-overlay" id="loading">
							<i class="fa fa-spinner fa-spin fa-fw margin-bottom"></i>
						</div>
						<div class="fr-box fr-basic fr-top">
							<div
								class="fr-toolbar fr-desktop fr-top fr-basic fr-sticky fr-sticky-off"
								style="top: 0px;">
								<button tabindex="-1" title="Italic (Ctrl+I)"
									class="fr-command fr-btn fr-btn-font_awesome fr-hidden"
									id="italic-1" role="button" aria-pressed="false" type="button"
									data-cmd="italic">
									<i class="fa fa-italic" aria-hidden="true"></i><span
										class="fr-sr-only">Italic</span>
								</button>
								<button tabindex="-1" title="Paragraph Format"
									class="fr-command fr-btn fr-dropdown fr-btn-font_awesome fr-selection"
									id="paragraphFormat-1" role="button" aria-expanded="false"
									aria-haspopup="true" aria-controls="drop" type="button"
									data-cmd="paragraphFormat">
									<span style="width: 100px;">본문</span>
								</button>
								<div class="fr-dropdown-menu" role="listbox" aria-hidden="true"
									aria-labelledby="paragraphFormat-1">
									<div class="fr-dropdown-wrapper" role="presentation">
										<div class="fr-dropdown-content" role="presentation">
											<ul class="fr-dropdown-list" role="presentation">
												<li role="presentation"><p role="presentation"
														style="margin: 0px !important; padding: 0px !important;">
														<a tabindex="-1" title="본문" class="fr-command"
															role="option" data-param1="N" data-cmd="paragraphFormat">본문</a>
													</p></li>
												<li role="presentation"><h1 role="presentation"
														style="margin: 0px !important; padding: 0px !important;">
														<a tabindex="-1" title="대제목" class="fr-command"
															role="option" data-param1="H1" data-cmd="paragraphFormat">대제목</a>
													</h1></li>
												<li role="presentation"><h2 role="presentation"
														style="margin: 0px !important; padding: 0px !important;">
														<a tabindex="-1" title="소제목" class="fr-command"
															role="option" data-param1="H2" data-cmd="paragraphFormat">소제목</a>
													</h2></li>
												<li role="presentation"><blockquote role="presentation"
														style="margin: 0px !important; padding: 0px !important;">
														<a tabindex="-1" title="인용" class="fr-command"
															role="option" data-param1="blockquote"
															data-cmd="paragraphFormat">인용</a>
													</blockquote></li>
											</ul>
										</div>
									</div>
								</div>
								<button tabindex="-1" title="Bold (Ctrl+B)"
									class="fr-command fr-btn fr-btn-font_awesome" id="bold-1"
									role="button" aria-pressed="false" type="button"
									data-cmd="bold">
									<i class="fa fa-bold" aria-hidden="true"></i><span
										class="fr-sr-only">Bold</span>
								</button>
								<button tabindex="-1" title="Strikethrough (Ctrl+S)"
									class="fr-command fr-btn fr-btn-font_awesome"
									id="strikeThrough-1" role="button" aria-pressed="false"
									type="button" data-cmd="strikeThrough">
									<i class="fa fa-strikethrough" aria-hidden="true"></i><span
										class="fr-sr-only">Strikethrough</span>
								</button>
								<button tabindex="-1" title="Font Family"
									class="fr-command fr-btn fr-dropdown fr-btn-font_awesome fr-selection"
									id="fontFamily-1" role="button" aria-expanded="false"
									aria-haspopup="true" aria-controls="drop" type="button"
									data-cmd="fontFamily">
									<i class="fa fa-font" aria-hidden="true"></i><span
										class="fr-sr-only">Font Family</span>
								</button>
								<div class="fr-dropdown-menu" role="listbox" aria-hidden="true"
									aria-labelledby="fontFamily-1">
									<div class="fr-dropdown-wrapper" role="presentation">
										<div class="fr-dropdown-content" role="presentation">
											<ul class="fr-dropdown-list" role="presentation">
												<li role="presentation"><a tabindex="-1" title="Arial"
													class="fr-command" role="option"
													style="font-family: Arial, Helvetica, sans-serif;"
													data-param1="Arial,Helvetica,sans-serif"
													data-cmd="fontFamily">Arial</a></li>
												<li role="presentation"><a tabindex="-1"
													title="Georgia" class="fr-command" role="option"
													style="font-family: Georgia, serif;"
													data-param1="Georgia,serif" data-cmd="fontFamily">Georgia</a></li>
												<li role="presentation"><a tabindex="-1" title="Impact"
													class="fr-command" role="option"
													style="font-family: Impact, Charcoal, sans-serif;"
													data-param1="Impact,Charcoal,sans-serif"
													data-cmd="fontFamily">Impact</a></li>
												<li role="presentation"><a tabindex="-1" title="Tahoma"
													class="fr-command" role="option"
													style="font-family: Tahoma, Geneva, sans-serif;"
													data-param1="Tahoma,Geneva,sans-serif"
													data-cmd="fontFamily">Tahoma</a></li>
												<li role="presentation"><a tabindex="-1"
													title="Times New Roman" class="fr-command" role="option"
													style="font-family: Times New Roman, Times, serif;"
													data-param1="Times New Roman,Times,serif"
													data-cmd="fontFamily">Times New Roman</a></li>
												<li role="presentation"><a tabindex="-1"
													title="Verdana" class="fr-command" role="option"
													style="font-family: Verdana, Geneva, sans-serif;"
													data-param1="Verdana,Geneva,sans-serif"
													data-cmd="fontFamily">Verdana</a></li>
											</ul>
										</div>
									</div>
								</div>
								<button tabindex="-1" title="Font Size"
									class="fr-command fr-btn fr-dropdown fr-btn-font_awesome fr-selection"
									id="fontSize-1" role="button" aria-expanded="false"
									aria-haspopup="true" aria-controls="drop" type="button"
									data-cmd="fontSize">
									<i class="fa fa-text-height" aria-hidden="true"></i><span
										class="fr-sr-only">Font Size</span>
								</button>
								<div class="fr-dropdown-menu" role="listbox" aria-hidden="true"
									aria-labelledby="fontSize-1">
									<div class="fr-dropdown-wrapper" role="presentation">
										<div class="fr-dropdown-content" role="presentation">
											<ul class="fr-dropdown-list" role="presentation">
												<li role="presentation"><a tabindex="-1" title="8"
													class="fr-command" role="option" data-param1="8px"
													data-cmd="fontSize">8</a></li>
												<li role="presentation"><a tabindex="-1" title="9"
													class="fr-command" role="option" data-param1="9px"
													data-cmd="fontSize">9</a></li>
												<li role="presentation"><a tabindex="-1" title="10"
													class="fr-command" role="option" data-param1="10px"
													data-cmd="fontSize">10</a></li>
												<li role="presentation"><a tabindex="-1" title="11"
													class="fr-command" role="option" data-param1="11px"
													data-cmd="fontSize">11</a></li>
												<li role="presentation"><a tabindex="-1" title="12"
													class="fr-command" role="option" data-param1="12px"
													data-cmd="fontSize">12</a></li>
												<li role="presentation"><a tabindex="-1" title="14"
													class="fr-command" role="option" data-param1="14px"
													data-cmd="fontSize">14</a></li>
												<li role="presentation"><a tabindex="-1" title="18"
													class="fr-command" role="option" data-param1="18px"
													data-cmd="fontSize">18</a></li>
												<li role="presentation"><a tabindex="-1" title="24"
													class="fr-command" role="option" data-param1="24px"
													data-cmd="fontSize">24</a></li>
												<li role="presentation"><a tabindex="-1" title="30"
													class="fr-command" role="option" data-param1="30px"
													data-cmd="fontSize">30</a></li>
												<li role="presentation"><a tabindex="-1" title="36"
													class="fr-command" role="option" data-param1="36px"
													data-cmd="fontSize">36</a></li>
												<li role="presentation"><a tabindex="-1" title="48"
													class="fr-command" role="option" data-param1="48px"
													data-cmd="fontSize">48</a></li>
												<li role="presentation"><a tabindex="-1" title="60"
													class="fr-command" role="option" data-param1="60px"
													data-cmd="fontSize">60</a></li>
												<li role="presentation"><a tabindex="-1" title="72"
													class="fr-command" role="option" data-param1="72px"
													data-cmd="fontSize">72</a></li>
												<li role="presentation"><a tabindex="-1" title="96"
													class="fr-command" role="option" data-param1="96px"
													data-cmd="fontSize">96</a></li>
											</ul>
										</div>
									</div>
								</div>
								<button tabindex="-1"
									class="fr-command fr-btn fr-btn-font_awesome" id="color-1"
									role="button" type="button" data-cmd="color" data-popup="true">
									<i class="fa fa-tint" aria-hidden="true"></i><span
										class="fr-sr-only">Colors</span>
								</button>
								<button tabindex="-1" title="Align"
									class="fr-command fr-btn fr-dropdown fr-btn-font_awesome"
									id="align-1" role="button" aria-expanded="false"
									aria-haspopup="true" aria-controls="drop" type="button"
									data-cmd="align">
									<i class="fa fa-align-left" aria-hidden="true"></i><span
										class="fr-sr-only">Align</span>
								</button>
								<div class="fr-dropdown-menu" role="listbox" aria-hidden="true"
									aria-labelledby="align-1">
									<div class="fr-dropdown-wrapper" role="presentation">
										<div class="fr-dropdown-content" role="presentation">
											<ul class="fr-dropdown-list" role="presentation">
												<li role="presentation"><a tabindex="-1"
													title="Align Left" class="fr-command fr-title"
													role="option" data-param1="left" data-cmd="align"><i
														class="fa fa-align-left" aria-hidden="true"></i><span
														class="fr-sr-only">Align Left</span></a></li>
												<li role="presentation"><a tabindex="-1"
													title="Align Center" class="fr-command fr-title"
													role="option" data-param1="center" data-cmd="align"><i
														class="fa fa-align-center" aria-hidden="true"></i><span
														class="fr-sr-only">Align Center</span></a></li>
												<li role="presentation"><a tabindex="-1"
													title="Align Right" class="fr-command fr-title"
													role="option" data-param1="right" data-cmd="align"><i
														class="fa fa-align-right" aria-hidden="true"></i><span
														class="fr-sr-only">Align Right</span></a></li>
												<li role="presentation"><a tabindex="-1"
													title="Align Justify" class="fr-command fr-title"
													role="option" data-param1="justify" data-cmd="align"><i
														class="fa fa-align-justify" aria-hidden="true"></i><span
														class="fr-sr-only">Align Justify</span></a></li>
											</ul>
										</div>
									</div>
								</div>
								<button tabindex="-1" title="Undo (Ctrl+Z)"
									class="fr-command fr-btn fr-btn-font_awesome fr-disabled"
									id="undo-1" role="button" aria-disabled="true" type="button"
									data-cmd="undo">
									<i class="fa fa-rotate-left" aria-hidden="true"></i><span
										class="fr-sr-only">Undo</span>
								</button>
								<button tabindex="-1" title="Redo (Ctrl+Shift+Z)"
									class="fr-command fr-btn fr-btn-font_awesome fr-disabled"
									id="redo-1" role="button" aria-disabled="true" type="button"
									data-cmd="redo">
									<i class="fa fa-rotate-right" aria-hidden="true"></i><span
										class="fr-sr-only">Redo</span>
								</button>
								<button tabindex="-1" title="Clear Formatting"
									class="fr-command fr-btn fr-btn-font_awesome"
									id="clearFormatting-1" role="button" type="button"
									data-cmd="clearFormatting">
									<i class="fa fa-eraser" aria-hidden="true"></i><span
										class="fr-sr-only">Clear Formatting</span>
								</button>
								<button tabindex="-1" title="Code View"
									class="fr-command fr-btn fr-btn-font_awesome" id="html-1"
									role="button" aria-pressed="false" type="button"
									data-cmd="html">
									<i class="fa fa-code" aria-hidden="true"></i><span
										class="fr-sr-only">Code View</span>
								</button>
							</div>
							<div class="fr-sticky-dummy" style="height: 41px;"></div>
							<div class="fr-wrapper show-placeholder"
								style="overflow: auto; max-height: 1000px;" dir="auto">
								<div class="fr-element fr-view" aria-disabled="false"
									style="min-height: 300px;" dir="auto" contenteditable="true"
									spellcheck="true">
									<p>
										<br>
									</p>
								</div>
								<span class="fr-placeholder"
									style="text-align: left; line-height: 23.1px; padding-top: 10px; padding-right: 14px; padding-left: 14px; font-size: 14px; margin-top: 0px; margin-right: 0px; margin-left: 0px;">게시글을
									작성해 주세요.</span>
							</div>
							<span class="fr-counter" style="bottom: 1px; margin-right: 2px;">0/10000</span>
							<div class="fr-quick-insert" style="left: -9999px; top: -9999px;">
								<a tabindex="-1" title="Quick Insert" class="fr-floating-btn"
									role="button"><svg xmlns="http://www.w3.org/2000/svg"
										viewBox="0 0 32 32">
									<path
										d="M 22 16.75 L 16.75 16.75 L 16.75 22 L 15.25 22 L 15.25 16.75 L 10 16.75 L 10 15.25 L 15.25 15.25 L 15.25 10 L 16.75 10 L 16.75 15.25 L 22 15.25 L 22 16.75 Z" /></svg></a>
							</div>
						</div>
						<textarea name="content" class="post-editor" id="edit"
							style="display: none;"></textarea>
					</div>
					<span class="view-msg"><i class="fa fa-info-circle"
						aria-hidden="true"></i> 코드보기로 직접 HTML 작성 시에는 다른 기능을 이용할 수 없습니다.</span>
					<div class="fr-overlay"></div>

					<!-- Post Publish Guide -->
					<div class="post-guide dropup">
						<button class="button-xs button-alert dropdown-toggle"
							type="button" data-toggle="dropdown">
							<span class="fa fa-exclamation"></span>글쓰기 가이드
						</button>
						<div class="dropdown-info dropdown-menu">
							<div class="dropdown-info-content">
								<h3>
									<i class="fa fa-info-circle" aria-hidden="true"></i> 글쓰기 가이드
								</h3>
								<ul>
									<li>동영상은 유투브, 비메오의 공유주소 만 등록 가능합니다.</li>
									<li>직접 동영상 업로드는 지원하지 않습니다.</li>
									<li>에디터에 드래그를 통한 이미지 업로드는 지원하지 않습니다.</li>
									<li>http://가 있는 텍스트의 경우 자동으로 링크를 지원합니다.</li>
									<li>업로드 이미지는 가로 780PX보다 큰 경우 본문에 보여질 때 780PX로 축소되어 보여집니다.</li>
									<li>본문 게시글은 넓이 780PX까지 보여집니다.</li>
									<li>직접 코드를 입력을 통해 글작성 시 해킹에 위험이 있는 코드는 저장 시 모두 자동 제거 됩니다.</li>
									<li>모바일에서 글 작성 시 에디터 편집 기능을 이용하 실 수 없습니다.</li>
									<li>이미 '이미지추가'를 통해 업로드한 이미지를 클릭하면 본문에 이미지를 다시 올릴 수 있습니다.</li>
								</ul>
							</div>
						</div>
					</div>

					<!-- Attachments Region -->
					<div class="post-extras" data-role="fileupload">

						<div class="form new-post-form upload-type-form mobile_none">
							<table>
								<tbody>
									<tr>
										<th>이미지 게시 방식</th>
										<td>
											<div
												class="btn-group bootstrap-select select upload-type-select">
												<button title="본문 내 편집"
													class="btn dropdown-toggle btn-default" type="button"
													data-toggle="dropdown">
													<span class="filter-option pull-left">본문 내 편집</span>&nbsp;<span
														class="bs-caret"><span class="caret"></span></span>
												</button>
												<div class="dropdown-menu open">
													<ul class="dropdown-menu inner" role="menu">
														<li class="selected" data-original-index="0"><a
															tabindex="0" data-tokens="null"><span class="text">본문
																	내 편집</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li>
														<li data-original-index="1"><a tabindex="0"
															data-tokens="null"><span class="text">본문 상단</span><span
																class="glyphicon glyphicon-ok check-mark"></span></a></li>
														<li data-original-index="2"><a tabindex="0"
															data-tokens="null"><span class="text">본문 하단</span><span
																class="glyphicon glyphicon-ok check-mark"></span></a></li>
													</ul>
												</div>
												<select name="imageLocation" tabindex="-98"
													class="select upload-type-select">
													<option value="IN">본문 내 편집</option>
													<option value="TOP">본문 상단</option>
													<option value="BOTTOM">본문 하단</option>
												</select>
											</div>
											<button class="button-sm" style="display: none;"
												type="button" data-role="btn-open-image-location-popup"
												data-toggle="modal" data-target="#upload-type-modal">모바일
												게시 방식 버튼</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>

						<!-- 모바일 이미지 게시 방식 Modal -->
						<div tabindex="-1" class="modal" id="upload-type-modal"
							role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="myModalLabel">
											<i class="fa fa-exclamation-circle" aria-hidden="true"></i>
											모바일 이미지 게시 방식 알림
										</h4>
									</div>
									<div class="modal-body" style="display: none;">
										<button class="selected" type="button"
											data-role="btn-image-location" data-value="TOP">본문
											상단</button>
									</div>

									<ul class="info-list">
										<li>모바일 기기에서는 이미지 게시 방식 중 <strong>'본문 상단'</strong> 만 사용하실
											수 있습니다.
										</li>
										<li>이미지는 추가 시 업로드한 순서대로 화면에 보여집니다.</li>
									</ul>
									<div class="modal-footer">
										<button class="btn btn-primary" type="button"
											data-role="btn-image-location-apply">확인하기</button>
									</div>
								</div>
							</div>
						</div>

						<div class="upload upload-image multiple-images">
							<ul class="upload-selector">
								<li><button class="button-md" type="button"
										data-role="fileupload-add-btn" data-type="image">
										이미지 추가<span class="fa fa-plus"></span>
									</button></li>
								<li class="upload-tip">최대 업로드 이미지 <strong>20개</strong> /
									이미지 최대 업로드 용량 <strong>10 MB</strong> / 업로드 가능 확장자 <strong>jpg,gif,png,jpeg</strong>
								</li>
							</ul>
							<ul class="upload-preview" data-role="fileupload-image-preview">
							</ul>
						</div>


					</div>

					<div class="form new-post-form">
						<table>



							<tbody>
								<tr>
									<th>CCL</th>
									<td>
										<div class="btn-group bootstrap-select select">
											<button title="CCL 사용안함"
												class="btn dropdown-toggle btn-default" type="button"
												data-toggle="dropdown">
												<span class="filter-option pull-left">CCL 사용안함</span>&nbsp;<span
													class="bs-caret"><span class="caret"></span></span>
											</button>
											<div class="dropdown-menu open">
												<ul class="dropdown-menu inner" role="menu">
													<li class="selected" data-original-index="0"><a
														tabindex="0" data-tokens="null"><span class="text">CCL
																사용안함</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li>
													<li data-original-index="1"><a tabindex="0"
														data-tokens="null"><span class="text">CCL 사용</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
												</ul>
											</div>
											<select name="cclUseYn" tabindex="-98" class="select">
												<option value="false">CCL 사용안함</option>
												<option value="true">CCL 사용</option>
											</select>
										</div>
										<div class="btn-group bootstrap-select select"
											style="display: none;">
											<button title="영리목적" class="btn dropdown-toggle btn-default"
												type="button" data-toggle="dropdown">
												<span class="filter-option pull-left">영리목적</span>&nbsp;<span
													class="bs-caret"><span class="caret"></span></span>
											</button>
											<div class="dropdown-menu open">
												<ul class="dropdown-menu inner" role="menu">
													<li class="selected" data-original-index="0"><a
														tabindex="0" data-tokens="null"><span class="text">영리목적</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
													<li data-original-index="1"><a tabindex="0"
														data-tokens="null"><span class="text">비영리목적</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
												</ul>
											</div>
											<select name="cclProfitYn" tabindex="-98" class="select">
												<option value="true">영리목적</option>
												<option value="false">비영리목적</option>
											</select>
										</div>
										<div class="btn-group bootstrap-select select"
											style="display: none;">
											<button title="변경금지" class="btn dropdown-toggle btn-default"
												type="button" data-toggle="dropdown">
												<span class="filter-option pull-left">변경금지</span>&nbsp;<span
													class="bs-caret"><span class="caret"></span></span>
											</button>
											<div class="dropdown-menu open">
												<ul class="dropdown-menu inner" role="menu">
													<li class="selected" data-original-index="0"><a
														tabindex="0" data-tokens="null"><span class="text">변경금지</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
													<li data-original-index="1"><a tabindex="0"
														data-tokens="null"><span class="text">동일조건변경허락</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
													<li data-original-index="2"><a tabindex="0"
														data-tokens="null"><span class="text">변경허락</span><span
															class="glyphicon glyphicon-ok check-mark"></span></a></li>
												</ul>
											</div>
											<select name="cclChange" tabindex="-98" class="select"
												data-role="">
												<option value="N">변경금지</option>
												<option value="C">동일조건변경허락</option>
												<option value="Y">변경허락</option>
											</select>
										</div>
									</td>
								</tr>

								<tr>
									<th>출처</th>
									<td><input name="source" class="text-field-lg" type="text"
										value=""></td>
								</tr>


							</tbody>
						</table>
					</div>

					<div class="form-button-region">
						<button class="button-lg button-light-blue" onclick="app.write();"
							type="button" data-role="btn-write">쓰기</button>
						<button class="button-lg" onclick="app.cancel();" type="button">취소</button>
					</div>

				</form>

				<input id="stopword_configTitle" type="hidden" value="★"> <input
					id="stopword_configComment" type="hidden" value="◎">

			</div>

			<div class="sidebar">
				<!-- 로그인 후 -->
				<div class="side-account after">
					<form id="myinfoForm">
						<ul class="account">
							<li class="account-info"><span class="account-name">
									<a class="nick" href="/service/mypage/myInfo">Supersonic</a> <a
									class="button-ss nick" href="/service/mypage/setting"><i
										class="fa fa-cog" aria-hidden="true"></i></a>
							</span> <a class="account-msg new" href="/service/mypage/scrap"> <span
									class="fa fa-bookmark-o"></span>
							</a> <a class="account-noti new" onclick="popup.messagesPopup();">
									<span class="fa fa-envelope-o" id="newMessageInfo"></span>
							</a> <a class="account-noti new" onclick="popup.notiPopup();"> <span
									class="fa fa-bell-o" id="newAlramInfo"></span>
							</a></li>
							<li class="account-nav"><a href="/service/mypage/myArticle"><i
									class="fa fa-pencil-square-o" aria-hidden="true"></i> 나의글</a></li>
						</ul>
					</form>
					<form name="logout" action="/service/logout" method="post">
						<input name="_csrf" type="hidden"
							value="fcbbb34f-52e7-4f52-afe0-5c0fa816953d"> <input
							class="button-xs" type="submit" value="로그아웃">
					</form>
				</div>
				<!-- // 로그인 후 -->


				<div class="div-rs-side-foot affix" id="div-pc-side"
					data-google-query-id="CNSmz5PSxtQCFYwqlgodDbUEKA">
					<script>
						googletag.cmd.push(function() {
							googletag.display('div-pc-side');
						});
					</script>
					<div id="google_ads_iframe_/44950606/cs4-pc-side_0__container__"
						style="border: 0pt currentColor; border-image: none; width: 160px; height: 600px; display: inline-block;">
						<iframe width="160" height="600" title="3rd party ad content"
							id="google_ads_iframe_/44950606/cs4-pc-side_0"
							src="https://tpc.googlesyndication.com/safeframe/1-0-9/html/container.html"
							frameborder="0" marginwidth="0" marginheight="0" scrolling="no"
							style="border: 0px currentColor; border-image: none; vertical-align: bottom;"
							data-is-safeframe="true"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>