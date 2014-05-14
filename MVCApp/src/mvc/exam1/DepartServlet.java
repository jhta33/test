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
		
		//�̰��� bean���� �ϴ°� ����. controller�� �̷��� ����
		/*
		if(param.equals("kor")){
			advice.add("1. ��� ���ؾ� �Ѵ�.");
			advice.add("2. ��� ����ؾ� �Ѵ�.");
			advice.add("3. �ѱ����̸� �� ����.");
		}
		else if(param.equals("eng")){
			advice.add("1. ��� ���ؾ� �Ѵ�.");
			advice.add("2. ��� ����ؾ� �Ѵ�.");
			advice.add("3. �����̸� �� ����.");
		}
		else if(param.equals("com")){
			advice.add("1. ��ǻ�͸� ���ؾ� �Ѵ�.");
			advice.add("2. ��ǻ�͸� ����ؾ� �Ѵ�.");
			advice.add("3. ���������� �� ����.");
		}
		else if(param.equals("bus")){
			advice.add("1. �濵�� ���ؾ� �Ѵ�.");
			advice.add("2. �濵�� ����ؾ� �Ѵ�.");
			advice.add("3. �̰���� �� ����.");
		}
		*/
		
		
		//************���İ� ���� ����************
		req.setAttribute("advice", advice);	//advice��� ���� advice�� ���� �����Ų��. 
		RequestDispatcher view =			//getRequestDispatcher : �����Ų ������ �о���� ���� �������ִ� �޼ҵ�
				req.getRequestDispatcher("/views/result.jsp");		//WebContent���� ������.
		view.forward(req,resp);
		//*****************************************
		//��� ����� jsp���� ����ϴ� ���� ����.
		/*
		resp.setCharacterEncoding("euc-kr");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>����� ������ �а��� ���� �����Դϴ�.</h1>");
		for(int i =0;i<advice.size();i++){
			out.println(advice.get(i)+"<br/>");
		}
		out.println("</body></html>");
		out.close();
		*/
	}
}
