package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet이란?
 * - 외부에서 특정 페이지(URL)의 요청(Request)에 따라 응답(Response) 내용을 사용자가 정의한 class
 * - ex) login 요청 -> id, pw를 통해 사용자 인증여부 확인 -> 로그인 결과(성공/실패)를 응답 
 * - 서블릿은 요청과 응답 사이에 사용자가 정의한 기능에 대한 로직(알고리즘)을 구현한 구조
 * 
 * 사용법 : HttpsServlet을 상속하고, doGet doPost를 재정의(오버라이딩 @Override)하여 사용함
 */
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// 객체직렬화의 버전으로 코드가 바뀔때마다 변경해야하나 보통 안한다.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("사용자 요청 확인!! (doGet 호출됨)");
		
		// 사용자 파라메터 받는 방법
		// - HttpServletRequest에 사용자의 url 및 각종 파라메터를 받아올수 있음
		String userUrl = req.getRequestURI();
		System.out.println("사용자의 요청 URL : " + userUrl);
		
		// 응답하는 방법(고전)
		// - HttpServletResponse를 활용하여 응답페이지 작성 가능
		resp.setContentType("text/html;charset=UTF-8"); // 응답할 페이지의 타입을 결정
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>FirstServlet 응답한 최초의 메세지!!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("post로 호출됨!!");
		doGet(req, resp);
	}
}
