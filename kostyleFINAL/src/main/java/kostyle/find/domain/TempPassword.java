package kostyle.find.domain;

public class TempPassword {
	
	public String temp_pw(){
		
		//아스키 코드 33~126번까지 특수문자, 영대소문자, 숫자 포함 => 랜덤으로 10개뽑아서 비밀번호 만들기
		String randomPw = "";
		
		char[] ascii = 
			{' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			  'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			  'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
			};
		
		for (int i = 0; i < 10; i++) {
			int random = (int)((Math.random() * 62) + 1);
            randomPw += ascii[random];
        }
		return randomPw;
	}
}
