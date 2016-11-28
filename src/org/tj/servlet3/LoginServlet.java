package org.tj.servlet3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cs = request.getCookies();
		Cookie c = null;
		HttpSession session = request.getSession();
		if(cs != null){
			for(Cookie cookie : cs){
				if("loginfo".equals(cookie.getName())){
					c = cookie;
					break;
				}
			}
		}
		if(c == null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username);
			if("messi".equals(username) && "12306".equals(password)){
				System.out.println("手动登录成功");
				Cookie ck = new Cookie("loginfo", username+"&"+password);
				ck.setMaxAge(2*60);
				response.addCookie(ck);
				session.setAttribute("login", "存入session的值");
				request.getRequestDispatcher("WEB-INF/jsp5/success.jsp").forward(request, response);
			}else{
				System.out.println("手动登录失败");
				request.setAttribute("message", "登录失败，请重新登陆");
				request.getRequestDispatcher("jsp5/login.jsp").forward(request, response);
			}
		}else{
			String loginfo = c.getValue();
			String username = loginfo.split("&")[0];
			String password = loginfo.split("&")[1];
			if("messi".equals(username) && "12306".equals(password)){
				session.setAttribute("login", "存入session的值");
				request.getRequestDispatcher("WEB-INF/jsp5/success.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "cookie自动登录失败，请重新登录");
				request.getRequestDispatcher("jsp5/login.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
