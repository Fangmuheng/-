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

public class UserAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//字符编码
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		
		User user = new User();
		user.setAge(age);
		user.setPassword(password);
		user.setUsername(username);
		
		UserInterface uif = new UserImpl();
		uif.addUser(user);
		
		List<User> list = uif.selectUserAll();
		//利用session 作用域向页面传值HttpSession
		request.getSession().setAttribute("userlist", list);
		//重定向
		response.sendRedirect(request.getContextPath()+"/userlist.jsp");
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
