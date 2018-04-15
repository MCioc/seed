 package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.KehuDao;
import com.oracle.dao.KehuDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Kehu;
import com.oracle.vo.PageInfo;

/**
 * Servlet implementation class ListKehu
 */
@WebServlet("/listkehu.do")
public class ListKehu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListKehu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��ҳ��Ϣ
    	PageInfo pageinfo=new PageInfo(request);
    	
    	//����dao
    	KehuDao dao=ServiceFactory.getObject(KehuDaoImpl.class);
    	//List<Kehu> list=dao.getAll();
    	dao.getAll(pageinfo);
    	
    	System.out.println(pageinfo.getList());
    	System.out.println(pageinfo.getCountPage());
    	System.out.println(pageinfo.getCurrentPage());
    	System.out.println(pageinfo.getPageSize());
    	System.out.println(pageinfo.getCountRecord());
    	
    	String uri=request.getRequestURI();
    	StringBuffer url=request.getRequestURL();
    	System.out.println(uri+"  "+url);
    	
    	uri=uri+"?currentPage=";
    	pageinfo.setAction(uri);
    	//����session,
    	//request.getSession().setAttribute("list", list);
    	
    	//ת��
    	//request.getRequestDispatcher("/files/listkehuxinxi.jsp").forward(request, response);
    	//�ض��򣬷���ʧ��ʽ
        response.sendRedirect("/seed/files/listkehuxinxi.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
