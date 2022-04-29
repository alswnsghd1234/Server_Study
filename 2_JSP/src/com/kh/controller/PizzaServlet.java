package com.kh.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name=request.getParameter("userName");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String message=request.getParameter("message");
        
        String pizza=request.getParameter("pizza");
        String[] toppings=request.getParameterValues("topping");
        String[] sides=request.getParameterValues("side");
        String payment=request.getParameter("payment");
        
        //요청처리 (보통의 상황에선 DB에 SQL문 실행하러 controller(servlet)->service->Dao
        
        int price = 0;
        
        switch(pizza) {
        case "콤비네이션피자" : price += 8000; break;
        case "치즈피자" : price += 7000; break;
        case "포테이토피자" : price += 7500; break;
        case "고구마피자" : price += 7500; break;
        case "불고기피자" : price += 9000; break;
        
        }
        
        if(toppings !=null) { //하나라도 선택했다면 
            for(int i=0; i<toppings.length; i++) {
                switch(toppings[i]) {
                case "고구마무스" :
                case "콘크림무스" : price+=2000; break;
                
                case "파인애플토핑" : price+=1500; break;
                
                case "치즈바이트" :
                case "치즈크러스트": price+=3500; break;
                
                case "치즈토핑": price+=2000; break;
                }
            }
        }
    
        if(sides != null) {
            for(int i=0; i<sides.length; i++) {
                switch(sides[i]) {
                case "콜라" :
                case "사이다" : price+=2500; break;
                
                case "갈릭소스" : 
                case "핫소스":
                case "피클":price+=500; break;
                
                case "파마산치즈가루":price+=300; break;
                }
            }
        }
        
        //요청처리 끝났으니 사용자에게 응답하기
        //요청처리 페이지 만들어서 응답 위임하기
        //그전에 데이터들 담아서 보내기 request에 attribute 영역에 넣기
        
        request.setAttribute("userName", name);
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("message",message);
        request.setAttribute("pizza", pizza);
        request.setAttribute("toppings", toppings);
        request.setAttribute("sides", sides);
        request.setAttribute("payment",payment);
        request.setAttribute("price", price);
        
        //응답할 뷰 선택
        RequestDispatcher view = request.getRequestDispatcher("views/05_PizzaPayment.jsp");
        
        //선택한 뷰가 사용자에게 보여지도록 보내기
        view.forward(request, response);
        
        
        System.out.println(name);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(message);
        System.out.println(pizza);
        System.out.println(String.join(",", toppings));
        System.out.println(String.join(",", sides));
        System.out.println(payment);
        System.out.println(price);
        
        
        
        
    
    
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}