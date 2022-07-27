package com.servlet.basic2;

import java.io.IOException
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LifeCycle이란?
 * - JVM내에서 Class(객체, 인스턴스)가 어떻게 생성되고 소멸하는지에 대한 흐름
 * - 일정한 생명주기에 따라 객체가 생성되고 메소드가 호출되는 것이 특징
 */

@WebServlet("/life.do")
public class LifeCycleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("0. static을 통한 초기화문");
	}
	
	public LifeCycleServlet() { // 생성자
		System.out.println("1. LifeCycleServlet 생성자 호출");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() : 최초 한번만 서블릿이 실행될때 호출됨");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3. service() 호출 : doGet, doPost를 호출하기 직전에 한번 호출 됨");
		super.service(req, resp); // 이거 없으면 doget,dopost 호출하지 않음!! 주의할것!
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. doGet() : 사용자의 get 요청이 들어올때 실행되는 코드");
		
		resp.setContentType("text/html;charset=UTF-8"); // 응답페이지 컨텐츠를 설정
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		pw.append("<html>");
		pw.append("<body>");
		pw.append("<h1> LifeCycleServlet </h1>");
		pw.append("</body>");
		pw.append("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. doPost() : 사용의 post 요청이 들어올때 실향되는 코드");
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("5. destroy() : 서블릿이 소멸하기 직전에 호출됨. (실제 호출타이밍은 알수 없음. 잘안됨..)");
		// ※ 주의 : 언제 호출될지 예상하기 어려움으로 이 함수를 사용하지 않길 권함.
		//          객체 소멸이 되는 지점은 서버가 종료되거나 재시작할때 정도로 생각하면된다.
		//          주로 로그용도로 활용됨.
	}
}

















