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
import com.oracle.vo.Kehu;

/**
 * Servlet implementation class AddKehu
 */
@WebServlet("/addkehu.do")
public class AddKehu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKehu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
    	String companyName=request.getParameter("companyName");
		String linkMan=request.getParameter("linkMan");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		String descript=request.getParameter("descript");
		
		Kehu company=new Kehu();
		company.setCompanyName(companyName);
		company.setLinkMan(linkMan);
		company.setTel(tel);
		company.setAddress(address);
		company.setDescript(descript);
		System.out.println(company);
		//调用dao
		KehuDao dao=ServiceFactory.getObject(KehuDaoImpl.class);
		dao.add(company);
		response.sendRedirect("/javaee0119/listkehu.do");
		//request.getRequestDispatcher("listkehuxinxi.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
