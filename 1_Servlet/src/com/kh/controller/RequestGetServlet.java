package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("불러와~");
		/*
		 * Get방식으로 요청을 보내면 doGet메소드가 자동으로 호출된다.
		 * 첫번째 매개변수인 HttpServletRequest 객체에 요청시 전달된 데이터들이 담긴다. (사용자가 입력한 값, 요청 전송방식, 요청한 사용자의 ip 등등)
		 * 두번째 매개변수인 HttpServletResponse는 요청 처리 후에 응답을 하기위해 필요한 객체이다.
		 * 
		 *  요청을 처리하기위해 요청시 전달된 값을 꺼내야한다. (사용자가 입력한값)
		 *  request의 parameter 영역에 있는 데이터(key-value 형태로 이루어져있음)
		 *  request의 parameter 영역으로부터 전달된 데이터를 꺼내는 메소드
		 *  request.getParameter("키값") : String 꺼내질때 문자열로 꺼내지기 때문에 자료형 변환 작업이 필요하다.
		 *  request.getParameterValues("키값") : String[](그에 해당하는 value값들) - 하나의 key값으로 여러개의 value값들을 받을 경우 배열 형식으로 반환한다
		 *  
		 * 
		 * 
		 * */
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String country = request.getParameter("country");
		double height = Double.parseDouble(request.getParameter("height"));
		
		//체크박스와 같이 복수개의 정보를 받을땐 배열로 받는다
		String[] foods = request.getParameterValues("food");
		
		
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(country);
		System.out.println(height);
		System.out.println(foods);
		
		if(foods==null) {
			System.out.println("foods :"+"없음");
		}else {
			System.out.println("foods : "+String.join(",", foods));
			//배열에 있는 모든값들을 구분자를 통해서 하나의 문자열로 반환시켜주는 메소드 String.join("구분자",객체)
		}
	
	/*
	 * 꺼내온 값들을 가지고 요청처리를 해야한다.(DB의 상호작용)
	 * 보통의 흐름 : Service의 메소드 호출시 뽑은 값들 전달해서 Dao호출 - DB SQL문 실행 - 결과 반환
	 * 
	 * int result = new MemberService().insertMember(name,gender,age,country,height,foods);
	 * if(result>0){
	 * 성공시 commit 실패시 rollback
	 * }
	 * 우리가 했던 mvc패턴 매체에서 service나 dao는 크게 변동사항이 없고 view(console로 했었는데 이전 html/css/js/jq를 활용해 jsp로 바뀌게 되니까)
	 * controller는 servlet으로 대체되기 때무넹 나머지 흐름은 동일하니 복습할때 mvc패턴 복습
	 * 
	 * 위와같은 요청처리를 다 했다는 가정하에 (아직 db 연동 안함) 다시 사용자에게 보여질 화면을 응답한다고 했을때
	 *
	 * servlet에서 바로 응답 페이지를 구현한다면
	 * 장점 : java 코드 내에 작성하기 때문에 반복문이나 조건문등 손쉬운 메소드들을 사용할 수 있다.
	 * 단점 : 복잡, 혹시라도 이후에 html을 수정해야 한다면 직접 java코드내에서 수정을 해야하기 때문에 서버를 재구동 시켜야한다.
	 * 
	 * 
	 * 
	 * 
	 * */
	
	//response 객체를 통해 사용자에게 html(응답화면) 전달
	//이 출력내용은 html형식이고 인코딩은 utf-8이다 라고 전달
	response.setContentType("text/html; charset=UTF-8");
	
	//응답하고자하는 사용자(요청했던 사용자)와의 스트림생성(사용자와의 연결통로)
    PrintWriter out = response.getWriter();
    
    //생성된 스트림을 통해 응답 내용인 html 구문을 한줄씩 출력한다.
    
    out.println("<html>");
    out.println("<head>");
    out.println("<style>");
    out.println("h1{color:red}");
    out.println("#name{color:orange}");
    out.println("#age{color:yellow}");
    out.println("#country{color:green}");
    out.println("#height{color:blue}");
    out.println("li {color:purple}");
    out.println("span{border:1px solid black}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>개인정보 응답화면</h1>");
    out.println("<span id='name'>"+name+"</span> 님은");
    out.printf("<span id='age'>%d</span> 살이고 ", age);
    out.printf("<span id='country'>%s</span> 에 살고", country);
    out.printf("<span id='height'>%.1f</span> cm이고 ", height);
    
    out.print("성별은 ");
    if(gender==null) {
        out.print("선택을 하지 않았습니다.");
    }else {
        if(gender.contentEquals("M")) {
            out.print("<span id='gender'>남자</span>입니다.<br>");
        }
        else {
            out.print("<span id='gender'>여자</span>입니다.<br>");
        }
    }
    
    out.print("좋아하는 음식은 ");
    if(foods == null) {
        out.println("없습니다.");
    }else {
        out.print("<ul>");
        for(int i=0; i<foods.length;i++) {
            out.printf("<li>%s</li>", foods[i]);
        }
        out.print("</ul>");
    }
    
    out.println("</body>");
    out.println("</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
