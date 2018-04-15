package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.dao.KehuDao;
import com.oracle.dao.KehuDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Kehu;
import com.oracle.vo.PageInfo;

/**
 * Servlet implementation class AjaxListKehu
 */
@WebServlet("/ajaxlistkehu.do")
public class AjaxListKehu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxListKehu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer currentPage=Integer.valueOf(request.getParameter("currentPage"));		
		PageInfo pageinfo=new PageInfo(request);
		
		KehuDao dao=ServiceFactory.getObject(KehuDaoImpl.class);
		dao.getAll(pageinfo);
		
		System.out.println(pageinfo.getCountRecord());
		System.out.println(pageinfo.getCountPage());
		
		//转换成json类型的字符串
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(pageinfo.getCountPage());
		
		request.getRequestDispatcher("sublistkehu.jsp").forward(request, response);
		
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
