package com.hibernate.usermanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorHandlerServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		String requestedURL = (String) request.getServletContext().getAttribute("requestedURL");
		request.setAttribute("servlet_name", servletName);
		request.setAttribute("request_uri", requestUri);
		
		if (statusCode != null && statusCode == 404) {
			request.getRequestDispatcher("/WEB-INF/JSP/Error.jsp").forward(request, response);
		}
		else if(statusCode != null && statusCode == 500){
			request.getRequestDispatcher("/WEB-INF/JSP/no_user_found.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher(requestedURL).forward(request, response);
		}
	}

}
