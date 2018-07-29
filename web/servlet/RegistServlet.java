package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.User;
import com.hwua.service.impl.UserServiceImpl;

/**
 * 注册的servlet
 */
public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.处理请求及响应中文乱码
		//2.通过请求对象获取注册表单数据
		String uname = req.getParameter("userName");
		String pwd = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		String identity = req.getParameter("identity");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		//3.数据验证
		if(uname==null || pwd==null || sex==null || birthday==null || identity==null || email==null || mobile==null || address==null){
			resp.getWriter().write("<script type='text/javascript'>alert('注册信息不能为空!')</script>");
			resp.setHeader("refresh", "1;url=view?page=regist");//一秒钟定时刷新到url路径处
			return;
		}
		//4.封装对象
		User user = new User(uname,pwd,sex,birthday,identity,email,mobile,address,1);
		//5.调用业务逻辑层完成注册业务
		UserServiceImpl usi = new UserServiceImpl();
		boolean flag = usi.insertUser(user);
		if (flag) {
			resp.getWriter().write("<script type='text/javascript'>alert('注册成功！确认跳到登录...')</script>");
			resp.setHeader("refresh", "1;url=view?page=login");
			//resp.sendRedirect("view?page=login");
		}else{
			resp.getWriter().write("<script type='text/javascript'>alert('用户名已存在,注册失败!')</script>");
			resp.setHeader("refresh", "1;url=view?page=regist");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}





