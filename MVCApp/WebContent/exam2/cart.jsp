<%@page import="mvc.exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	Vector booklist = (Vector)session.getAttribute("cart");
%>
<%
try{
	if(booklist.size() > 0 || booklist != null){
%>
<b>���� �ֹ��� ����</b><br/>
<table border="1">
	<tr>
		<th>���� ����</th><th>�۰�</th><th>����</th><th>����</th>
	</tr>
	<%for(int i=0; i< booklist.size();i++){ 
		BookDto dto = (BookDto)booklist.get(i);
	%>
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQuantity()%></td>
		<td>
			<form method="post" action="/MVCApp/cart.action">
				<!-- <input type="checkbox" ip="check" name="check" value="<%=i%>"/> -->
				<input type="hidden" name="command" value="DEL"/>
				<input type="hidden" name="idx" value="<%=i%>"/>
				<input type="submit" value="����"/>
			</form>
		</td>
	</tr>
	<%} %>
</table>
<br/>
<form method="post" action="/MVCApp/cart.action">
<input type="hidden" name="command" value="CHK"/>
	<input type="submit" value="üũ �ƿ�"/>
</form>
<%
}
}
catch(Exception e){
	System.out.println(e);
}
%>