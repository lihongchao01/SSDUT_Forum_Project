package Servlet_test;

import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/firstServlet",urlPatterns={"/aa"})
public class FirstServlet extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String[]color=request.getParameterValues("color");
			String country=request.getParameter("country");
			PrintStream out=new PrintStream(response.getOutputStream());
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet测试</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("您的名字："+name+"<hr/>");
			out.println("您的性别:"+ gender+"<hr/>");
			out.println("您喜欢的颜色：");
			for(String c : color){
				out.println(c+" ");
			}
			out.println("<hr/>");
			out.println("您来自的国家："+country+"<hr/>");
			out.println("</body>");
			out.println("</html>");
		}
}
