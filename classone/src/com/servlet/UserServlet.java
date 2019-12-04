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
	//�ӿڣ��������ݺ���תҳ��
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("dopost");
		//ȷ������
		request.setCharacterEncoding("utf-8");
		//��ֵ,���������login��(�û���������)input��ǩ�е�nameֵһ��
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("�û���:"+username+",����:"+password);
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		//���ýӿ�-��̬ ָ��ʵ����
		UserInterface uif = new UserImpl();
		boolean bool = uif.loginSelect(u);
		
		
		//��תҳ�� 
		//ת�� ת�� �� ������һ������    �����������ַͣ������������(ˢ��һ�ξ������ݿ����һ������)
		//�ض��� �� ��������������   �����������ַͣ����jspҳ����    ���׶�ֵ

		if(bool){

			List<User> list = uif.selectUserAll();
			//����session ��������ҳ�洫ֵHttpSession
			request.getSession().setAttribute("userlist", list);
			//�ض���
			response.sendRedirect(request.getContextPath()+"/userlist.jsp");
		}else{
			//ת��
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
