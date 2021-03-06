package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("불러와~");
		//요청시 전달된 값은 request parameter 영역에 담겨있다.
		
		//POST 방식 요청은 기본 인코딩이 iso 로 되어있기 때문에 UTF-8로 맞춰야한다.
		// 값을 꺼내오기 전에 인코딩 설정을 해야한다.
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String country = request.getParameter("country");
		double height = Double.parseDouble(request.getParameter("height"));
		String[] foods = request.getParameterValues("food");
		
		System.out.println(name+gender+age+country+height+foods);
		
		//service - dao - db 처리 완료 후 반환
		//위에 처리를 끝마치고 사용자에게 응답화면을 보여주면 된다.
		
		//순수 Servlet : java 코드 내에 html을 작성하는 형태
		//JSP(Java Server Page) : html 내에 java 코드를 작성하는 형태
		//응답페이지 구성을 jsp에게 넘긴다.
		//응답페이지에서 필요로하는 데이터들을 request 객체에 담아서 보내야 한다.
		//request에 attribute 영역에 (키 밸류) 형태로 담아서 보낸다.
		//request.setAttribute("키" "밸류")ㅣ
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("country", country);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		//1)응답하고자 하는 뷰(jsp)를 서낵하면서 생성한다.
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		
		//2)포워딩
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("포스트");
		doGet(request, response);
	}

}
