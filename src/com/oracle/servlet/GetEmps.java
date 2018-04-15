package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.dao.EmpDao;
import com.oracle.dao.EmpDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class GetEmps
 */
@WebServlet("/files/getemps.do")
public class GetEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmps() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EmpDao dao=ServiceFactory.getObject(EmpDaoImpl.class);
		 
		 List<Emp> list=dao.getAll();
		 
		 ObjectMapper mapper=new ObjectMapper();
		 String json=mapper.writeValueAsString(list);
		 
		 response.setContentType("text/plain;charset=UTF-8");
		 response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
