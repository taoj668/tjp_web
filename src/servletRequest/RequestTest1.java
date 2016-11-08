package servletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw =response.getWriter();
		Enumeration<String> reqHeadInfos=request.getHeaderNames();
		pw.write("ÈçÏÂ£º");
		pw.write("<hr/>");
		while(reqHeadInfos.hasMoreElements()){
			String headName = reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);
			pw.write(headName+":"+headValue);
			pw.write("<br/>");
		}
		
 	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
