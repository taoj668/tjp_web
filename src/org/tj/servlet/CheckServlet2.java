package org.tj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CheckServlet2")
public class CheckServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String checkCode = request.getParameter("validateCode");
        if(kaptchaValue == null || kaptchaValue == ""||!checkCode.equalsIgnoreCase(kaptchaValue)) {
            System.out.println("验证失败");
            request.setAttribute("errorCheckCode","对不起，您输入的验证码有误");
            request.getRequestDispatcher("/Kaptcha.jsp").forward(request, response);
            return;
        }else{
            System.out.println("验证通过");
        }   

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
