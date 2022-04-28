<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"% errorPage="errorPage500.jsp"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
	<h1>page 지시어</h1>
	
	<%
		//ArrayList 사용
		//지시어 부분에 import="java.util.ArrayList" 속성 추가해주기
		ArrayList<String> list =new ArrayList<>();
		list.add("안녕");
		list.add("하이");
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today2 = sdf.format(today);
	
	%>
	
	<p>
		리스트의 길이 : <%list.size(); %> <br>
		0번 인덱스 값: <%list.get(0); %> <br>
		1번 인덱스 값: <%list.get(1); %> <br>
		오늘은<%=today %>
		오늘은<%=today2 %>
		
	</p>
</body>
</html>