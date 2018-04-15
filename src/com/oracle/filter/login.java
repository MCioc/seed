package com.oracle.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.vo.Emp;

/**
 * Servlet Filter implementation class login
 */
@WebFilter({"*.do", "*.jsp", "*.html" })
public class login implements Filter {
     List list=new ArrayList();
    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//强制转型
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//获得session的登陆消息
		Emp user=(Emp)req.getSession().getAttribute("user");
		
		//获得档次请求的uri
		String uri=req.getRequestURI();
		String path=req.getContextPath();
		System.out.println(uri+"-----"+path);
		uri=uri.replaceAll(path, "");
		System.out.println(uri);
		
		if(user!=null){
			//放行
			chain.doFilter(request, response);
		}else if(list.contains(uri)){
			//登陆界面 放行
				chain.doFilter(request, response);
		}else{
			//不放行
			//res.sendRedirect("login.html");会无限的访问这个网页
			res.setContentType("text/html;charset=UTF-8");
            PrintWriter out=res.getWriter();
            out.println("<script>window.top.location.href='"+path+"/login.html'</script>");
            out.flush();
            out.close();
		}
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		list.add("/login.html");
		list.add("/userlogin.do");
	}

}
