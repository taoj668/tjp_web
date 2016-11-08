 package org.tj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S02_cookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		Cookie[] cks = request.getCookies();
		Cookie ck = null;
		if(cks != null){
			for(Cookie cookie : cks){
				if("lastTime".equals(cookie.getName())){
					ck = cookie;
					break;
				}
			}
		}
		if(ck == null){
			pw.write("<h1>这是您第一次访问本站</h1>");
		}else{
			SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pw.write("您上次访问是在："+adf.format(new Date(Long.parseLong(ck.getValue()))));
		}
		
		Cookie cookie = new Cookie("lastTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
