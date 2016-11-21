package org.tj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S02_cookie2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;Charset=UTF-8");
		Cookie[] cookies = req.getCookies();
		String usinfo = null;
		if(cookies != null){
			for(Cookie ck : cookies){
				if("usinfo".equals(ck.getName())){
					usinfo = ck.getValue();
				}
			}
		}
		if(cookies == null || usinfo == null){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if("zhangsan".equals(username) && "z123".equals(password)){
			usinfo = username + "&" + password;
			Cookie cookie = new Cookie("usinfo", usinfo);
			cookie.setMaxAge(60);
			resp.addCookie(cookie);
			
			req.getSession().setAttribute("username", username);
			resp.sendRedirect(req.getContextPath()+"/jsp2/result.jsp");
			}else{
				resp.sendRedirect(req.getContextPath()+"/jsp2/test_cookie2.jsp");
			}
		}else{
			String username = usinfo.split("&")[0];
			String password = usinfo.split("&")[1];
			if("zhangsan".equals(username) && "z123".equals(password)){
				req.getSession().setAttribute("username", username);
				resp.sendRedirect(req.getContextPath()+"/jsp2/result.jsp");
				
			}
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
