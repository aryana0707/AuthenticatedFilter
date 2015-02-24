package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Authenticate implements Filter {

	FilterConfig config=null;
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
		PrintWriter out=response.getWriter();
		String au=request.getParameter("auth");
		if(au.equals("ram")){
			chain.doFilter(request, response);
		}else{
			out.println("<html>"
					+ "<body>"
					+ "<h1>YOU ARE NOT AN AUTHENTICATED USER.</h1>"
					+ "</body>"
					+ "</html>");
		}
		}catch(Exception e){
			RequestDispatcher rd=request.getRequestDispatcher("hello.html");
			rd.forward(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
	}

}
