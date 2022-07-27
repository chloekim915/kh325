package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method.do")
public class HttpMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨!!");
		
		// 사용자 파라메터 읽는 방법 : requset에 getParameter로 읽을수 있음
		// ※ 서버에서 파라메터는 html의 name 속성을 읽어온다! 
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String height = req.getParameter("height");
		String food = req.getParameter("food");
		String[] foods = req.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(food);
		System.out.println(Arrays.toString(foods));
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>사용자 정보 출력</h1>");
		out.printf("<div> 이름 : %s </div>", name);
		out.printf("<div> 나이 : %s </div>", age);
		out.printf("<div> 성별 : %s </div>", gender);
		out.printf("<div> 키 : %s </div>", height);
		out.printf("<div> 좋아하는 음식 : %s </div>", food);
		out.printf("<div> 좋아하는 음식들 : %s </div>", Arrays.toString(foods));
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post로 호출됨!!");
		req.setCharacterEncoding("UTF-8"); // post 방식은 사용자의 요청을 UTF-8로 변환해야 인코딩이 적용됨!
		doGet(req, resp);
	}
}












