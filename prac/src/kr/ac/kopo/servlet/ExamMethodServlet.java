package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamMethodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
		String hob = request.getParameter("hobby"); // 여러개의 hobby 중 맨 처음 나오는 hobby만 찾는다.
		String[] hobby = request.getParameterValues("hobby"); // 복수개의 결과가 있을 때에는 getParameterValues
		
		
		
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
		out.println("이름(name) : " + name + "<br>");
		out.println("취미 : ");
		for(int i = 0 ; i < hobby.length ; i++) {
		out.println(hobby[i]+"&nbsp;");
		}
		out.println("==============================================<br>");
		out.println("  </body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
	}
	
}
