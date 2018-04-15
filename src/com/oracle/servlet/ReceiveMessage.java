package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.MessageDao;
import com.oracle.dao.MessageDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class Receive
 */
@WebServlet("/files/receive.do")
public class ReceiveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得当前登陆的人
    	Integer empID=((Emp)request.getSession().getAttribute("user")).getEmpID();
    	System.out.println("当前登陆的人："+empID);
    	//dao
    	MessageDao dao=ServiceFactory.getObject(MessageDaoImpl.class);
    	
    	request.setAttribute("list", dao.getReceiveMessage(empID));
    	
    	//转发
    	request.getRequestDispatcher("listtakexiaoxi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
