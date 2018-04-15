package com.oracle.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.MessageDao;
import com.oracle.dao.MessageDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class ListMessage
 */
@WebServlet("/files/listmessage.do")
public class ListMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer empID=((Emp)request.getSession().getAttribute("user")).getEmpID();
		//dao
		
		MessageDao dao=ServiceFactory.getObject(MessageDaoImpl.class);
		
		List<Object[]> list=dao.getSendMessage(empID);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("listsendxiaoxi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
