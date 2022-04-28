<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//이 구문을 스크립틀릿이라고 한다. html문서내에 자바코드를 쓸수있는 영역
	//현재 이 jsp에서 필요로하는 데이터들 -> servlet에서 전달(forward)받은 request의 attribute에 담겨있음
	//request.getAttribute("키값") : Object (그에 해당하는 벨류값의 자료형)
	//Object 형식에서 내가 받고자 하는 자료형으로 형변환해서 담아주면 된다.
	
	
	String name = (String)request.getAttribute("name");
	int age = (int)request.getAttribute("age");
	String gender =(String)request.getAttribute("gender");
	String country =(String)request.getAttribute("country");
	double height = (double)request.getAttribute("height");
	String[] foods = (String[])request.getAttribute("foods");
%>    
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인정보 응답화면</h1>

	<span id="name"><%=name%></span> 님은
	<span id="age"><%=age %></span> 살이며
	<span id="country"><%=country %></span> 에 살고
	<span id="height"><%=height %></span> cm이고,

	성별은
	<%if(gender==null){%>
		선택을 하지 않았습니다.<br>
	<%}else{%>
		<%if(gender.equals("M")){%>
			<span id="gender">남자</span> 입니다. <br>
		<%}else{%>
			<span id="gender">여자</span> 입니다. <br>
		<%}%>
	<%}%>

	좋아하는 음식은
	<%if(foods==null){%>
		없습니다.
	<%}else{%>
		<ul>
			<%for(int i=0; i<foods.length; i++){%>
				<li><%=foods[i] %></li>
			<%}%>
		</ul>
	<%}%>

</body>
</html>