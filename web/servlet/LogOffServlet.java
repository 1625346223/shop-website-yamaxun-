package com.hwua.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.User;
import com.hwua.service.impl.UserServiceImpl;
//注销的servlet
public class LogOffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//判断用户是否登录来确定能不能注销
		HttpSession session = req.getSession(false);
		if(session==null || session.getAttribute("login_user")==null){
			resp.getWriter().write("<script type=\"text/javascript\">alert('未登录不能注销')</script>");
			resp.setHeader("refresh", "1;url=productPagenation");//定时重定向
		}else{//已经登录成功了
			User user = (User)session.getAttribute("login_user");
			String uname=user.getHu_user_name();
			UserServiceImpl usi = new UserServiceImpl();
			usi.updateUserStatus(uname, 0);
			session.removeAttribute("login_user"); //将域中的属性对移除,模拟注销
			resp.getWriter().write("<script type=\"text/javascript\">alert('已注销!')</script>");
			resp.setHeader("refresh", "1;url=productPagenation");//定时重定向
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}