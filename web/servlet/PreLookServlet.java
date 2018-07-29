package com.hwua.web.servlet;

import java.io.IOException;
import java.util.HashSet;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.User;

public class PreLookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//从session域中获取用户名作为cookie的键
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("login_user");
		if (user!=null) {
			
			String hu_user_name = user.getHu_user_name();
			//1.需要获取商品的信息id(复选框)
			String products_id = req.getParameter("productid");//1-2-3-4...
			//2.从请求中获取商品id的cookie键
			Cookie[] cookies = req.getCookies();
			String[] old_pid = null;//存放客户端传过来的pid
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if (hu_user_name.equals(cookie.getName())) {
						String olds = cookie.getValue();
						if (olds!=null) {
							old_pid = olds.split("-");
						}
					}
				}
			}
			//2.为购物车的商品进行id拼接
			StringBuilder sb = new StringBuilder();
			HashSet<String> hs = new HashSet<>();
			if (products_id!=null) {//商品不为空
				
				hs.add(products_id);//将本次选择的商品id放入到集合中
				
				if (old_pid!=null) {//处理第一次访问(没有cookie的情况)
					for (String o_id : old_pid) {
						hs.add(o_id);//将上一次添加到购物车的商品再次放入到集合中
					}
				}
				
				for (String p_id : hs) {
					sb.append(p_id).append("-");
				}
				//3.创建cookie对象
		
				
				Cookie cookie = new Cookie(hu_user_name, sb.substring(0, sb.length()-1));//p_id记录的是购物车内所有的商品id,中间使用-连接
				if (hs.size()>5) {
					cookie = new Cookie(hu_user_name, sb.substring(2, sb.length()-1));
				}
				//4.cookie通过响应对象写出到客户端浏览器
				resp.addCookie(cookie);
				
			}
		}
		req.getRequestDispatcher("view?page=product_view").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
