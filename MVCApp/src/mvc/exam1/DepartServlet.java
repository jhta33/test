package mvc.exam1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("servlet test...");
		
		String param = req.getParameter("depart");
		
		ArrayList advice = new DepartAdvice().getAdvice(param);
		
		//이것은 bean에서 하는게 좋다. controller는 이런거 안함
		/*
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
		*/
		
		
		//************공식과 같은 문법************
		req.setAttribute("advice", advice);	//advice라는 곳에 advice의 값을 저장시킨다. 
		RequestDispatcher view =			//getRequestDispatcher : 저장시킨 정보를 읽어들일 파일 지정해주는 메소드
				req.getRequestDispatcher("/views/result.jsp");		//WebContent에서 시작함.
		view.forward(req,resp);
		//*****************************************
		//출력 기능은 jsp에서 담당하는 것이 좋다.
		/*
		resp.setCharacterEncoding("euc-kr");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>당신이 선택한 학과에 대한 조언입니다.</h1>");
		for(int i =0;i<advice.size();i++){
			out.println(advice.get(i)+"<br/>");
		}
		out.println("</body></html>");
		out.close();
		*/
	}
}
