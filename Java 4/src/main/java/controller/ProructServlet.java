package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import DAO.CategoryDAO;
import DAO.ProductsDAO;
import Utils.EncryptUtils;
import entities.Category;
import entities.Product;
import entities.User;

/**
 * Servlet implementation class ProructServlet
 */
@WebServlet({
	"/product/index",
	"/product/create",
	"/product/store",
	"/product/show",
	"/product/edit",
	"/product/update",
	"/product/delete",
	"/product/byID",
})
public class ProructServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private CategoryDAO cateDAO;
	private ProductsDAO productDAO;
	
    public ProructServlet() {
         this.productDAO = new ProductsDAO();
         this.cateDAO = new CategoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		}else if (uri.contains("create")) {
			this.create(request, response);
		}else if (uri.contains("store")) {
			this.store(request, response);
		}else if (uri.contains("show")) {
			this.show(request, response);
		}else if (uri.contains("edit")) {
			this.edit(request, response);
		}else if (uri.contains("update")) {
			this.update(request, response);
		}else if (uri.contains("delete")) {
			this.delete(request, response);
		}else if (uri.contains("byID")) {
			this.byID(request, response);
		}else{
			//404
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		}else if (uri.contains("update")) {
			this.update(request, response);
		}else if (uri.contains("byID")) {
			this.byID(request, response);
		}else{
			//404
		}
	}
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> dsproduct = this.productDAO.all();
		List<Category> dsCate = this.cateDAO.all();
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("dsproduct", dsproduct);
		request.setAttribute("view", "/views/admin/products/index_product.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> dsCate = this.cateDAO.all();
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("view", "/views/admin/products/create_product.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String ten = request.getParameter("ten");
			Product product = new Product();
			product.setTen(ten);
			int id = Integer.parseInt(request.getParameter("category_id"));
			Category cate = this.cateDAO.findById(id);
			product.setCate(cate);
			BeanUtils.populate(product, request.getParameterMap());
			this.productDAO.create(product);
			session.setAttribute("meesage", "Success");
			response.sendRedirect("/Assignment_IT16305/product/index");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("error", "Failed");
			response.sendRedirect("/Assignment_IT16305/product/create");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(idStr);
			Product product = this.productDAO.findById(id);
			BeanUtils.populate(product, request.getParameterMap());
			this.productDAO.update(product);
			session.setAttribute("message", "Update SuccessFull!");
			response.sendRedirect("/Assignment_IT16305/product/index");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("error", "Update Failed");
			response.sendRedirect("/Assignment_IT16305/product/update");
		}
	}
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> dsproduct = this.productDAO.all();
		request.setAttribute("dsproduct", dsproduct);
		request.setAttribute("view", "/views/admin/products/create_product.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		try {
			Product pro = this.productDAO.findById(id);
			request.setAttribute("pro", pro);
			request.setAttribute("view", "/views/admin/products/edit_product.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		try {
			int id = Integer.parseInt(idStr);
			Product pro = this.productDAO.findById(id);
			this.productDAO.delete(pro);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("/Assignment_IT16305/product/index");
	}
	protected void byID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> dsproduct = this.productDAO.all();
		request.setAttribute("dsproduct", dsproduct);
		List<Category> dsCate = this.cateDAO.all();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		dsproduct = this.productDAO.byCateid(id);
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("dsproduct", dsproduct);
		request.setAttribute("view", "/views/admin/products/index_product.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

}
