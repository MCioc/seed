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
import com.oracle.vo.SendMessage;


/**
 * Servlet implementation class Send
 */
@WebServlet("/files/send.do")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Transactional
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String[] receive=request.getParameterValues("empid");
		String value=request.getParameter("select");
		String content=request.getParameter("content");
		System.out.println(title);
		System.out.println(receive);
		System.out.println(value);
		System.out.println(content);
		
		Integer[] empIDs=new Integer[receive.length];
		for(int i=0;i<empIDs.length;i++){
			empIDs[i]=Integer.valueOf(receive[i]);
			System.out.println(empIDs[i]);
		}
		SendMessage sendmessage=new SendMessage();
		sendmessage.setMessageTitle(title);
		sendmessage.setEmpID(( (Emp)request.getSession().getAttribute("user") ).getEmpID());
		sendmessage.setPriority(Integer.valueOf(value));
		sendmessage.setMessageContent(content);
		
		MessageDao dao=ServiceFactory.getObject(MessageDaoImpl.class);
		dao.send(sendmessage, empIDs);
		
		//response.sendRedirect("listsendxiaoxin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
