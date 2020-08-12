package hw.hw0625;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pinfoResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String[] mail = request.getParameterValues("mail");
		String job = request.getParameter("job");
		
		gender = (gender == "male") ? "남자" : "여자";
		
		int i=0;
		for(i=0 ; i < mail.length ;i++) {
			mail[i] = (mail[i].length() == 0) ? "받지않음" : "받음" ;
		}
		if(job == "com") {
			job="회사원";
		}else if(job == "stu") {
			job="학생";
		}else {
			job="기타";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("  <head>");
		out.println("     <title>pinfoResultServlet </title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("==============================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;개인정보출력<br>");
		out.println("==============================================<br>");
		out.println("이름 : " + name + "<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("암호 : " + pwd + "<br>");
		out.println("성별 : " + gender + "<br>");
		out.println("공지메일 : " + mail[0] + "<br>");
		out.println("광고메일 : " + mail[1] + "<br>");
		out.println("배송확인 : " + mail[2] + "<br>");
		out.println("직업 : " + job + "<br>");
		out.println("==============================================<br>");
		out.println("  </body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}
	
}
