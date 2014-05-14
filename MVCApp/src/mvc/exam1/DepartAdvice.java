package mvc.exam1;

import java.util.ArrayList;

public class DepartAdvice {
	public ArrayList getAdvice(String param){
		ArrayList advice = new ArrayList();
		if(param.equals("kor")){
			advice.add("1. 국어를 잘해야 한다.");
			advice.add("2. 국어를 사랑해야 한다.");
			advice.add("3. 한국인이면 더 좋다.");
		}
		else if(param.equals("eng")){
			advice.add("1. 영어를 잘해야 한다.");
			advice.add("2. 영어를 사랑해야 한다.");
			advice.add("3. 코쟁이면 더 좋다.");
		}
		else if(param.equals("com")){
			advice.add("1. 컴퓨터를 잘해야 한다.");
			advice.add("2. 컴퓨터를 사랑해야 한다.");
			advice.add("3. 빌게이츠면 더 좋다.");
		}
		else if(param.equals("bus")){
			advice.add("1. 경영을 잘해야 한다.");
			advice.add("2. 경영을 사랑해야 한다.");
			advice.add("3. 이건희면 더 좋다.");
		}
		return advice;
	}
}
