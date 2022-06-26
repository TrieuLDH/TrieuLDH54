package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.ProductsDAO;
import entities.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({ "/cart/index", "/cart/create", "/cart/store", "/cart/show", "/cart/edit", "/cart/update", "/cart/delete",

})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private ProductsDAO proDAO;
	public CartServlet() {
		proDAO = new ProductsDAO();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else if (uri.contains("insert")) {
			this.insert(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			// 404
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}

	protected void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> dsproduct = this.proDAO.all();
		request.setAttribute("dsproduct", dsproduct);
		request.setAttribute("view", "/views/admin/products/index_cart.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		try {
//			ArrayList<Cart> cartList = new ArrayList<>();
//			
//			int id = Integer.parseInt(request.getParameter("id"));
//			Cart c = new Cart();
//			c.setId(id);
//			c.setQuantity(1);
//			HttpSession session = request.getSession();
//			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//			
//			if (cart_list == null) {
//				cartList.add(c);
//				session.setAttribute("cart-list", cartList);
//			}else {
//				cartList = cart_list;
//				boolean exits = false;
//				
//				
//				for (Cart ca : cart_list) {
//					if (ca.getId() == id) {
//						exits = true;
//					}
//				}
//					if (!exits) {
//						cartList.add(c);
//						response.sendRedirect("/views/cart/index.jsp");
//					}
//				}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
