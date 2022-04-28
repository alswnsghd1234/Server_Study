<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
    <%--JSP 주석 : 개발자도구에 노출 안됨 --%>
    
    <h1>스크립팅 원소</h1>
    
    <%
    	// 스크립틀릿 : 이안에 일반적인 자바코드 작성(변수 선언 및 초기화,제어문 등등)
    	
    int sum=0;
    for(int i=0;i<=100;i++){
    	sum+=i;
    }
    System.out.println("덧셈과 끝 결과 출력 |"+ sum);
    out.println("덧셈과 끝 결과 출력 |"+ sum);
    %>
    
    <%
    	//배열 만들기
    	String[] food={"떡뽀기","곱창","육개","김치"};
    %>
    
    <h4>배열의길이 <%=food.length%></h4>
    <h4>배열값<%=String.join("-",food) %></h4>
</body>
</html>