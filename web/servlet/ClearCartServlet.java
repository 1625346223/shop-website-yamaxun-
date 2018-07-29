package com.hwua.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.NewCart;
import com.hwua.entity.Order;
import com.hwua.entity.OrderDetail;
import com.hwua.entity.Product;
import com.hwua.entity.User;
import com.hwua.service.impl.CartServiceImpl;
import com.hwua.service.impl.OrderDetailServiceImpl;
import com.hwua.service.impl.OrderServiceImpl;
import com.hwua.service.impl.ProductServiceImpl;

public class ClearCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户信息及系统时间
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("login_user");
		if (user==null) {
			resp.getWriter().write("<script type='text/javascript'>alert('亲，您还没有登录!')</script>");
			resp.setHeader("refresh", "1;url=view?page=login");//定时刷新(重定向)
			return;
		}
		long user_id = user.getHu_user_id();
		String user_name = user.getHu_user_name();
		String address = user.getHu_address();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		CartServiceImpl csi = new CartServiceImpl();
		List<NewCart> list = csi.queryProductInCart(user_id);
		double cost = 0;
		for (NewCart newCart : list) {
			cost += newCart.getHp_price()*newCart.getQuantity();		
		}
		//包装
		//添加到order订单user_id, user_name, address, time, cost, 1, 1
		Order order = new Order(user_id, user_name, address, time, cost, 1, 1);
		OrderServiceImpl osi = new OrderServiceImpl();
		int rows = osi.insertOrder(order);
		Order order2 = osi.queryOrderId(user_id);
		long ho_id = order2.getHo_id();
		
		
		for (NewCart newCart : list) {
			//获取商品编号及商品数量
			long pId = newCart.getHp_id();
			csi.deleteCart(pId);
			int quantity = newCart.getQuantity();
			//获取商品的价格、库存
			ProductServiceImpl psi = new ProductServiceImpl();
			Product product = psi.queryProduct(pId);
			double price = Double.parseDouble(product.getHp_price());
			int stock = Integer.parseInt(product.getHp_stock());
			double cost1 = price*quantity;
			
			//添加订单到detail数据库中ho_id, pId, quantity, cost
			OrderDetail orderDetail = new OrderDetail(ho_id, pId, quantity, cost1);
			OrderDetailServiceImpl odsi = new OrderDetailServiceImpl();
			odsi.insertOrderDetail(orderDetail);
			//修改库存
			int newStock = stock-quantity;
			psi.updateStock(newStock, pId);
				
		}
		
		req.getRequestDispatcher("view?page=shopping-result").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
