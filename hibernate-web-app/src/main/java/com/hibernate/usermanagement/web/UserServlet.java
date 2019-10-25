package com.hibernate.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.usermanagement.dao.UserDao;
import com.hibernate.usermanagement.dto.UserDto;

@WebServlet("/home/*")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6149042298515885311L;
	private UserDao userDao;

	@Override
	public void init() {
		userDao = new UserDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		String url = request.getRequestURI();
		try {
			switch (action) {
			case "/add":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
//			case "/edit":
//				getContactData(request, response);
//				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/search":
				showSearchPage(request, response);
				break;
			case "/list":
				getContactData(request, response);
				break;
			case "/":
				homePage(request, response);
				break;
			default:
				noPage(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo(); // returns after "/home"

		try {
			switch (action) {
			case "/add":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/edit":
				showSearchPage(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
//			case "/search":
//				editUrlUpdater(request, response);
//				break;
//			case "/update":
//				showEditForm(request, response);
//				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				getContactData(request, response);
				break;
			case "/":
				homePage(request, response);
				break;
			default:
				noPage(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void noPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String reqUrl = "requestedURL";
		String errorUrl = request.getContextPath() + "/error";
		request.getServletContext().setAttribute(reqUrl, "/WEB-INF/JSP/Error.jsp");
		response.sendRedirect(errorUrl);
	}

	private void getContactData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String reqUrl = "requestedURL";
		String errorUrl = request.getContextPath() + "/error";
		String phone = request.getParameter("phone");
		request.getServletContext().setAttribute("phone", phone);
		UserDto existingUserDto = userDao.getUser(phone);

		if (existingUserDto == null) {
			request.getServletContext().setAttribute(reqUrl, "/WEB-INF/JSP/no_user_found.jsp");
			response.sendRedirect(errorUrl);
		} else {
			request.getServletContext().setAttribute("user", existingUserDto);
			request.getRequestDispatcher("/WEB-INF/JSP/user-form.jsp").forward(request, response);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/insertContact.jsp");
		dispatcher.forward(request, response);
	}

	private void showSearchPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		System.out.println("alooo1");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/user-search.jsp");
		dispatcher.forward(request, response);
		System.out.println("alooo2");
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		UserDto newUserDto = new UserDto(email, phone, name, country);
		userDao.saveUser(newUserDto);
		System.out.println("saved");
		response.sendRedirect(request.getContextPath() + "/index.html");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String phone = (String) request.getServletContext().getAttribute("phone");
		UserDto userDto = new UserDto(email, phone, name, country);
		userDao.updateUser(userDto);
		request.getServletContext().setAttribute("user", userDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String phone = request.getParameter("phone");
		userDao.deleteUser(phone);
		response.sendRedirect("list");
	}

//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	request.getRequestDispatcher("/WEB-INF/JSP/user-form.jsp").forward(request, response);
//
//	}
//
//	private void editUrlUpdater(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.sendRedirect(request.getContextPath() + "/home/edit");
//	}
	
	private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/index.html").forward(request, response);	
	}
}