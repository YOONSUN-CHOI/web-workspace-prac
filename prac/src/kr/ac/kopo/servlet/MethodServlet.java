package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9999/Lectrue-WEB/method
public class MethodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		// request가 요청을 get으로 보낸건지 post로 보낸건지 가지고 있다. 뭐로 보낸건지 확인하자!!
		String method = request.getMethod();
		System.out.println("요청방식 : "+method);
		
		
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		// uri가 Lecture-WEB/method으로 요청될때 해당 doGet이 호출된다.
		
		
		
		//프로토콜, 주소, url, url 더한 값이라서 string아니고 stringbuffer로 append
		StringBuffer url = request.getRequestURL();
		System.out.println("url : "+url.toString());
		
		
		
		
		//id에 해당하는 값 뭔데?
		// name = value 에서 name으로 해당 value 추출
		String id = request.getParameter("id_get");
		System.out.println("id : "+id);
		
		
		
		
		
		
		
		// 이제 콘솔에 찍는 것 말고 응답으로 웹 브라우저에 결과 출력하자
		//html4 상단에 있는 Content-Type 이런거 설정해주자
		response.setContentType("text/html; charset=utf-8");
		
		
		
		//서버가 가진 데이터를 보낼것이니 outputstream
		//유니코드 포함할수도 있으니 문자스트림이 필요!
		//writer 객체 필요
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("  <head>");
		out.println("     <title>메소드 호출결과 </title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("==============================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;출력결과<br>");
		out.println("==============================================<br>");
		out.println("파라미터(id) : " + id + "<br>");
		out.println("요청방식 : " + method + "<br>");
		out.println("URI : " + uri + "<br>");
		out.println("URL : " + url + "<br>");
		out.println("==============================================<br>");
		out.println("  </body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		String method = request.getMethod();
		System.out.println("요청방식 : "+method);
		*/
		
		//post는 데이터가 body에 날라오는데 그 부분 인코딩해주기
		//걍암기해!!!! doPost에서는 setCharacterEncoding넣어주자!!!
		request.setCharacterEncoding("utf-8");
		
		
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String id = request.getParameter("id_post");
		response.setContentType("text/html; charset=utf-8");
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("  <head>");
		out.println("     <title>메소드 호출결과 </title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("==============================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;출력결과<br>");
		out.println("==============================================<br>");
		out.println("파라미터(id) : " + id + "<br>");
		out.println("요청방식 : " + method + "<br>");
		out.println("URI : " + uri + "<br>");
		out.println("URL : " + url + "<br>");
		out.println("==============================================<br>");
		out.println("  </body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}
	
	
	

}
