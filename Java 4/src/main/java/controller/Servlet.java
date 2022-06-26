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
import Utils.EncryptUtils;
import entities.User;

/**
 * Servlet implementation class Servlet
 */
@WebServlet({
	"/users/index",
	"/users/create",
	"/users/store",
	"/users/show",
	"/users/edit",
	"/users/update",
	"/users/delete",
})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
       userDAO = new UserDAO();
       categoryDAO = new CategoryDAO();
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/users/show.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User entity = new User();
		HttpSession session = request.getSession();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			
			String encryted = EncryptUtils.encrypt(request.getParameter("password"));
			entity.setPassword(encryted);
			this.userDAO.create(entity);
			session.setAttribute("meesage", "Success");
			response.sendRedirect("/Assignment_IT16305/users/show");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("error", "Failed");
			response.sendRedirect("/Assignment_IT16305/users/create");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(idStr);
			User lateValue = this.userDAO.findById(id);
			User newValue = new User();
			BeanUtils.populate(newValue, request.getParameterMap());
			session.setAttribute("meesage", "Update Successful");
			newValue.setPassword(lateValue.getPassword());
			this.userDAO.update(newValue);
			response.sendRedirect("/Assignment_IT16305/users/show");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("error", "Update Failed");
			response.sendRedirect("/Assignment_IT16305" + "/users/edit?id=" + idStr);
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		try {
			User entity = this.userDAO.findById(id);
			request.setAttribute("user", entity);
			request.setAttribute("view","/views/admin/users/edit.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			User entity = this.userDAO.findById(id);
			this.userDAO.delete(entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("/Assignment_IT16305/users/show");
	}

}
