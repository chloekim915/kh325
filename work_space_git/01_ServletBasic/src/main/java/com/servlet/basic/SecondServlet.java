package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 버전1의 문제점 : xml 관리하기 어려움 -> 개발자가 실수를 많이한다. -> 버그(인재) 발생한다!
 * 
 * 해결방법 : 어노테이션(@Annotation) 활용하여 class와 별도의 파라메터를 맵핑시킴
 * 사용법 : @WebServlet( ... )을 활용하는데, 인자로 이름과 url을 설정한다.
 */

// 방법1
@WebServlet(name = "second", urlPatterns = "/second.do")
// 방법2 - name 생략 가능하다!
//@WebServlet(urlPatterns = "/second.do")
// ※ 주의점 '/ 빼먹으면 안됀다!!'
// Tip, xml과 어노테이션 표기의 하이브리드도 가능하다....(?)
public class SecondServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("사용자 요청 확인!! (Second - doGet 호출됨)");
		
		System.out.println("URL : " + req.getRequestURI());
		System.out.println("서버 이름 : " + req.getServerName()); 
		System.out.println("서버 port : " + req.getServerPort());
		System.out.println("context path : " + req.getContextPath()); //★★★프로젝트의 주소를 가르침!!
		System.out.println("사용자 IP : " + req.getRemoteAddr());
		System.out.println("사용자 Port : " + req.getRemotePort());

		
		resp.setContentType("text/html;charset=UTF-8"); // 응답할 페이지의 타입을 결정
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>SecondServlet 응답한 두번째 메세지!!</h1>");
		out.println("<p> - 어노테이션을 통해 url과 서블릿간 맵핑이 가능하다.</p>");
		out.println("<p> - xml보다 개발자 관점에서는 편하다. 운영관점에서는 불편하다. </p>");
		out.println("<p> - 운영할때는 코드가 보이지 않음으로 xml 설정이 더 보기 쉽다. </p>");
		out.println("</body>");
		out.println("</html>");
	}

}
