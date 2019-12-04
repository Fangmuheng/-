package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.UserImpl;
import com.bao.UserInterface;
import com.pojo.User;

public class Exam1Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Exam1Servlet() {
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


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		User user = new User();
		List<User> list = new ArrayList<User>();
		UserInterface uif = new UserImpl();
		//如果写了id就直接按id查询直接返回数据
		if(request.getParameter("id")!=""){
			int id = Integer.parseInt(request.getParameter("id"));
			User user2 = new User();
			user2 = uif.selectUserById(id);
			list.add(user2);
			user.setId(id);
			request.getSession().setAttribute("userlist", list);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/userlist2.jsp");
		}//没写id就设置为null，按其他查询
		else{
			user.setId(null);

		if(request.getParameter("age")!=""){
			user.setAge(Integer.parseInt(request.getParameter("age")));
		}else{
			user.setAge(null);
		}
		if(request.getParameter("username")!=""){
			user.setUsername(request.getParameter("username"));
		}else{
			user.setUsername(null);
			
		}if((user.getAge()==null)&&(user.getUsername()==null)&&(user.getId()==null)){
			list = uif.selectUserAll();
			request.getSession().setAttribute("userlist", list);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/userlist2.jsp");
		}else{
			list = uif.selectUserByPart(user);
			request.getSession().setAttribute("userlist", list);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/userlist2.jsp");
			}}
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
