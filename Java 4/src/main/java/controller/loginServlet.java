package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Utils.EncryptUtils;
import entities.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userDAO;
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/admin/users/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = request.getParameter("email"),
				pwd = request.getParameter("password");
		if (email.length() == 0 || pwd.length() == 0) {
			session.setAttribute("errors", "Not Null");
			response.sendRedirect("/Assignment_IT16305/login");
		}
		
		User u = this.userDAO.findByEmail(email);
		boolean checked = EncryptUtils.check(pwd, u.getPassword());
		if (checked == true) {
			session.setAttribute("user", u);
			session.setAttribute("message", "Dang nhap thanh cong");
			response.sendRedirect("/Assignment_IT16305/users/index");
		}else {
			session.setAttribute("error", "Dang nhap that bai");
			response.sendRedirect("/Assignment_IT16305/users/login");
		}
	}
}
