package com.hwua.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.PageModel;
import com.hwua.entity.Product;
import com.hwua.service.impl.ProductServiceImpl;

/**
 * 商品分页的servlet
 */
public class ProductPagenationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.从请求中获取当前页参数
		String currentPage_s = req.getParameter("currentPage");
		String parentId = req.getParameter("parentid");
		String superParentId = req.getParameter("superparentid");
		String pname = req.getParameter("pname");
		int currentPage = 1;// 默认是首页
		if (currentPage_s != null && !"".equals(""+currentPage)) {
			currentPage = Integer.parseInt(currentPage_s);
		}
		int pageSize = 12;// 规定一页显示12个商品
		// 2.调用业务逻辑层获取pageModel
		ProductServiceImpl psi = new ProductServiceImpl();
		PageModel<Product> pageModel = null;
		
		if (pname==null&&parentId==null&&superParentId==null||"0".equals(superParentId)&&"0".equals(parentId)&&"".equals(pname)) {
			pageModel = psi.productPagenation(currentPage, pageSize);
		}else if (parentId!=null&&"0".equals(superParentId)&&"".equals(pname)) {
			pageModel = psi.productPagenation2(currentPage, pageSize, Integer.parseInt(parentId));
		}else if(superParentId!=null&&"0".equals(parentId)&&"".equals(pname)){
			pageModel = psi.productPagenation3(currentPage, pageSize, Integer.parseInt(superParentId));
		}else if (pname!=null&&!"".equals(pname)) {
			pageModel = psi.productPagenationMoHu(currentPage, pageSize, pname);
		}
		
		// 3.将pageModel放入request域中
		req.setAttribute("pageModel", pageModel);
		// 4.转发到index.jsp页面
		req.getRequestDispatcher("checkCategory").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
