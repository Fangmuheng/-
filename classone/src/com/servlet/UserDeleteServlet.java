package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.UserImpl;
import com.bao.UserInterface;
import com.pojo.User;

public class UserDeleteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserDeleteServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		UserInterface uif = new UserImpl();
		
		uif.deleteUser(id);
		
		List<User> list = uif.selectUserAll();
		//利用session 作用域向页面传值HttpSession
		request.getSession().setAttribute("userlist", list);
		//重定向
		response.sendRedirect(request.getContextPath()+"/userlist.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
