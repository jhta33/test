package mvc.exam2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("euc-kr");
		req.setCharacterEncoding("euc-kr");
		
		HttpSession session = req.getSession();
				
		Vector bookList = (Vector)session.getAttribute("cart"); //서버가 사용자에게 데이터 줄때만 유지. 끊어지면 데이터 사라짐.
		
		String cmd = req.getParameter("command");
		String idx = req.getParameter("idx");
			
		/*	
		String check[] = req.getParameterValues("check");
		for(int i=0;i<check.length;i++){
		int c_check = Integer.parseInt(check[i]);

	   if (check[i] != null) {
	      bookList.remove(Integer.parseInt(idx));
	   }}*/
	   //////////////////////
		if(cmd.equals("CHK")){
			RequestDispatcher view =
					req.getRequestDispatcher("/exam2/checkout.jsp");
			view.forward(req, resp);
		}
		else{
			if(cmd.equals("ADD")){
				if(bookList==null){
					bookList = new Vector();
				}
				bookList.add(getBook(req));				
			}
			else if(cmd.equals("DEL")){
				bookList.remove(Integer.parseInt(idx));
			}
			session.setAttribute("cart", bookList);
			RequestDispatcher view =
					req.getRequestDispatcher("/exam2/bookShop.jsp");
			view.forward(req, resp);
		}
		
	}
	public BookDto getBook(HttpServletRequest req){
		String book = req.getParameter("book");
		String qty = req.getParameter("quantity");
		
		StringTokenizer token = new StringTokenizer(book,"/");
		String title = token.nextToken().trim();		//trim 변환시 공백은 없애는 것
		String author = token.nextToken().trim();
		String price = token.nextToken().trim();
		
		BookDto dto = new BookDto();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPrice(Integer.parseInt(price));
		dto.setQuantity(Integer.parseInt(qty));
		
		return dto;
	}
}