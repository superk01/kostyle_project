package kostyle.join.persistence;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kostyle.join.domain.JoinJoin;

public class JoinValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		if(JoinJoin.class.isAssignableFrom(arg0)){//커맨드 객체로 쓰고있는 Board
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {//오브젝트로 받지만 실제는 보드객체가 들어가 있음
		JoinJoin join = (JoinJoin)arg0;
		
		if(join.getC_name() == null || join.getC_name().length() == 0){
			errors.rejectValue("c_name", "require", "이름을 입력하세요.");
		}
	}

}






