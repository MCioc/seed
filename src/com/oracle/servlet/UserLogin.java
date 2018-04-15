package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.EmpDao;
import com.oracle.dao.EmpDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;
import com.oracle.jrockit.jfr.RequestableEvent;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userlogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û�������
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		//����dao��ִ�в�ѯ
		EmpDao dao=ServiceFactory.getObject(EmpDaoImpl.class);
		Emp user=dao.select(userName, password);
		//������ȷ������session������index�������ض���login
		if(user!=null){
			 request.getSession().setAttribute("user", user);
		     System.out.println(request.getSession().getMaxInactiveInterval());
		     request.getRequestDispatcher("index.html").forward(request, response);

		}else{
			 response.sendRedirect("login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
