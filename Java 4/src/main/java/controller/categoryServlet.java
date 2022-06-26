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
import DAO.UserDAO;
import entities.Category;
import entities.User;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet({
	"/category/index",
	"/category/create",
	"/category/store",
	"/category/show",
	"/category/edit",
	"/category/update",
	"/category/delete",
})
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryServlet() {
        super();
        this.userDAO = new UserDAO();
        this.categoryDAO = new CategoryDAO();
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
		}else if (uri.contains("edit")) {
			this.edit(request, response);
		}else if (uri.contains("show")) {
			this.show(request, response);
		}else if (uri.contains("store")) {
			this.store(request, response);
		}else if (uri.contains("update")) {
			this.update(request, response);
		}else if (uri.contains("insert")) {
			this.insert(request, response);
		}else if (uri.contains("delete")) {
			this.delete(request, response);
		}else {
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
		}else {
			//404
		}
	}
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> dsUser = this.userDAO.all();
		request.setAttribute("dsUser", dsUser);
		request.setAttribute("view", "/views/admin/categories/create_category.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> dsUser = this.userDAO.all();
		request.setAttribute("dsUser", dsUser);
		request.setAttribute("view", "/views/admin/categories/create_category.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> dsCate = this.categoryDAO.all();
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("view", "/views/admin/categories/show_category.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
		try {
			String ten = request.getParameter("ten");
			Category cate = new Category();
			cate.setTen(ten);
			
			int id = Integer.parseInt(
				request.getParameter("user_id")
			);
			User user = this.userDAO.findById(id);
			cate.setUser(user);
			this.categoryDAO.create(cate);
			session.setAttribute("meesage", "Them danh muc thanh cong");
			response.sendRedirect("/Assignment_IT16305/category/show");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Them danh muc that bai");
			response.sendRedirect("/Assignment_IT16305/category/create");
		}
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		try {
			Category cate = this.categoryDAO.findById(id);
			request.setAttribute("cate", cate);
			
			request.setAttribute("view", "/views/admin/categories/edit_category.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(idStr);
			Category cate = this.categoryDAO.findById(id);
			BeanUtils.populate(cate, request.getParameterMap());
			this.categoryDAO.update(cate);
			session.setAttribute("meesage", "Update Sucessful");
			response.sendRedirect("/Assignment_IT16305/category/show");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Update Failed");
			response.sendRedirect("/Assignment_IT16305/category/update");
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			Category entity = this.categoryDAO.findById(id);
			this.categoryDAO.delete(entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("/Assignment_IT16305/category/show");
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
