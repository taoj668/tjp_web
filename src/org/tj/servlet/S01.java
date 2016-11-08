 package org.tj.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S01 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String demo1 = request.getParameter("demo1");
		System.out.println(demo1);
		String flag = "demo1提交数据:" + demo1;
		request.setAttribute("test", flag);
		request.getRequestDispatcher("jsp/demo2.jsp").forward(request, response);
		request.setAttribute("demo3",this.getServletContext().getInitParameter("demo3"));
//		String cn = "��ã��й�";
//		OutputStream os = response.getOutputStream();
//		os.write(cn.getBytes("UTF-8"));
//		PrintWriter pw = response.getWriter();
//		pw.write(cn);
//		this.getServletContext().getRequestDispatcher("/jsp/demo3.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/jsp/demo3.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
