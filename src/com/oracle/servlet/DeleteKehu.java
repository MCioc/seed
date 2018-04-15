package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.KehuDao;
import com.oracle.dao.KehuDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;

/**
 * Servlet implementation class DeleteKehu
 */
@WebServlet("/deletekehu.do")
public class DeleteKehu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKehu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得数据
    	String[] value=request.getParameterValues("delid");
    	Integer[] companyID=new Integer[value.length];
    	for(int i=0;i<value.length;i++){
    		companyID[i]=Integer.valueOf(value[i]);
    	}
    	//调用dao
    	KehuDao dao=ServiceFactory.getObject(KehuDaoImpl.class);
    	dao.delect(companyID);
    	
    	request.getRequestDispatcher("listkehu.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
