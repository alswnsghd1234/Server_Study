<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include</h1>
	
	<h2>01_ScriptingElement.jsp 파일 include</h2>
	<%@ include file="01_ScriptingElement.jsp" %>
	
	포함한 jsp상에 존재하는 변수를 가져다 쓸 수 있음 <br>
	1부터 100까지의 총합계 : <%=sum %>
</body>
</html>