package com.hwua.web.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.Product;
import com.hwua.entity.User;
import com.hwua.service.impl.ProductServiceImpl;

public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("login_user");
		if (user!=null) {
			
			String hu_user_name = user.getHu_user_name();
			//1.从请求中获取cookie中所有的商品id
			Cookie[] cookies = req.getCookies();//服务器获取cookie的方法
			LinkedList<Product> ll = new LinkedList<>();
			ProductServiceImpl psi = new ProductServiceImpl();
			Product product = null;
			if (cookies!=null) {//判断客户端是否有cookie传过来
				for (Cookie cookie : cookies) {
					if(hu_user_name.equals(cookie.getName())){
						String products_id = cookie.getValue();
						String[] p_ids = products_id.split("-");					
						for (String p_id : p_ids) {
							//此处需要调用业务逻辑层的方法来查询指定id的商品()
							product = psi.queryProduct(Long.parseLong(p_id));
							ll.addFirst(product);
						}
					}
				}
			}
			req.setAttribute("prelook", ll );
			
		}
		req.getRequestDispatcher("checkNews").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}