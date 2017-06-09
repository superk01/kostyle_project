
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

		<div id="contents">
			<div id="cont_area">
				<h3>
					회원 데이터 초기화
				</h3>
				
				<div id="context_in">
					<div class="myAdmin myid">
						<p class="findMsg">
							 고객님의 본인확인을 위해 비밀번호를 입력해주세요.
						</p>
						<form action="WithdrawalAction.mypage" method="post">
						<div class="findForm">
							<div class="findFormWrap">
								<p>
									<!-- <img src="img" alt="아이디"> -->
									<span>아이디</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- <input type="id" name="c_id"> -->
									<%=session.getAttribute("c_id") %>
									
								</p>
								<p>
									<label for="passwd">
										<!-- <img src="img" alt="비밀번호"> -->
										<span>비밀번호</span>&nbsp;&nbsp;&nbsp;
									</label>
									<input type="password" name="c_pass" id="passwd" title="비밀번호" class="Ty04">
								</p>
							</div>
						</div>
						<div class="findBtn">
							<input type="submit" value="확인">
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>