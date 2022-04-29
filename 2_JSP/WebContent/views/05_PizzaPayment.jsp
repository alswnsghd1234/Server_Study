<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("userName");
	String phone = (String)request.getAttribute("phone");
	String address = (String)request.getAttribute("address");
	String message = (String)request.getAttribute("message");
	
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] sides = (String[])request.getAttribute("sides");
	String payment = (String)request.getAttribute("payment");
	int price =(int)request.getAttribute("price");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 결제 페이지</title>
</head>
<body>
	<h1>피자 결제 페이지</h1>
	<h2>주문 내역</h2>
	
	<h3>[주문자 정보]</h3>
	
	<ul>
		<li>성함 : <%=userName %></li>
		<li>전화번호 : <%=phone %></li>
		<li>주소 : <%=address %></li>
		<li>요청사항 : <%=message %></li>	
	</ul>
	
	<br><br>
	<h3>[주문 정보]</h3>
	<ul>
		<li>피자 : <%=pizza %></li>
		<li>토핑: <%=String.join(",",toppings) %></li>
		<li>사이드: <%=String.join(",",sides) %></li>
		<li>결제방식: <%=payment %></li>	
	</ul>
	
	<br><br>
	
	<h3>위와 같이 주문하였습니다.</h3>
	
	<h1>총가격 : <%=price %>원</h1>
	
	
</body>
</html>