package com.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.UserImpl;
import com.bao.UserInterface;
import com.pojo.User;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	//接口：接收数据和跳转页面
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("dopost");
		//确定编码
		request.setCharacterEncoding("utf-8");
		//接值,参数必须和login中(用户名和密码)input标签中的name值一样
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名:"+username+",密码:"+password);
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		//调用接口-多态 指向实现类
		UserInterface uif = new UserImpl();
		boolean bool = uif.loginSelect(u);
		
		
		//跳转页面 
		//转发 转向 ： 服务器一次请求    最终浏览器地址停留在请求名上(刷新一次就向数据库添加一次数据)
		//重定向 ： 服务器两次请求   最终浏览器地址停留在jsp页面上    容易丢值

		if(bool){

			List<User> list = uif.selectUserAll();
			//利用session 作用域向页面传值HttpSession
			request.getSession().setAttribute("userlist", list);
			//重定向
			response.sendRedirect(request.getContextPath()+"/userlist.jsp");
		}else{
			//转发
			request.getRequestDispatcher("/loginfail.jsp").forward(request, response);
		}
		
		
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
