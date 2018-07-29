package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.User;
import com.hwua.service.impl.UserServiceImpl;

/**
 * 登录的servlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("login_user");
		if (user==null) {
			// 2.通过请求对象获取登录表单的数据
			String uname = req.getParameter("userName");
			String pwd = req.getParameter("passWord");
			// 3.数据验证
			if (uname == null || pwd == null) {
				/*resp.getWriter().write("<script type='text/javascript'>alert('登录信息不能为空!')</script>");
				resp.setHeader("refresh", "1;url=view?page=login");// 一秒钟定时刷新到url路径处*/				
				resp.sendRedirect("productPagenation");
				return;
			}
			//4.封装对象
			user = new User(uname, pwd);
			//5.调用service中的登录接口完成登录业务
			UserServiceImpl usi = new UserServiceImpl();
			User login_user1 = usi.queryUserForLogin(user);
			if (login_user1!=null) {//登录成功
				//将登录成功后的用户放入到session中(需要跟踪会话)
				usi.updateUserStatus(uname, 1);
				User login_user = usi.queryUserForLogin(user);
				//session = req.getSession();//创建session
				//new Cookie("JSESSIONID", session.getId());  //服务器自动发送的
				session.setAttribute("login_user", login_user);	
				
				//调用业务逻辑层查询所有的商品
				req.getRequestDispatcher("productPagenation").forward(req, resp);			
			}else {
				resp.getWriter().write("<script type='text/javascript'>alert('用户名或密码错误!')</script>");
				resp.setHeader("refresh", "1;url=view?page=login");//定时刷新(重定向)
			}
		}else {
			req.getRequestDispatcher("productPagenation").forward(req, resp);
		}		
	}
}

