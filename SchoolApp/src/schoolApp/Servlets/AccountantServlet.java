package schoolApp.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import my.poc.services.AccountantServices;

@WebServlet("/Accountant")
public class AccountantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountantServices service;

	public AccountantServlet() {
		service = new AccountantServices();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("type") != null) {
			if (request.getParameter("type").equals("search")) {
				request.getSession(false).setAttribute("key", request.getParameter("key"));
				String key = (String) request.getSession(false).getAttribute("key");
				System.out.println("key=" + key);
				int id = 0;
				try {
					id = Integer.parseInt(key);
				} catch (NumberFormatException | NullPointerException nfe) {
					id = 0;
				}
				System.out.println("id=" + id);
				if (key.isEmpty() && id == 0) {
					System.out.println("doing nothing");
					request.setAttribute("type", "FS");
					request.getSession(false).setAttribute("key", "");
				} else {
					try {
						System.out.println("executing qury");
						request.getSession(false).setAttribute("search", service.findStudent(id, key));
						request.getSession(false).setAttribute("key", key);
						request.setAttribute("type", "FS");
						System.out.println("search, key set");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if (request.getParameter("type").equals("Find Due")) {
				System.out.println("finding due");
				request.getSession(false).setAttribute("find", true);
				request.setAttribute("type", "FD");
			}
			else if (request.getParameter("type").equals("Get All Payments")) {
				System.out.println("get all payments");
				request.getSession(false).setAttribute("find", false);
				request.setAttribute("type", "FD");
			}
		} else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			request.setAttribute("type", "");
			request.getSession(true);
			refreshData(request, response);
			request.getSession(false).setAttribute("key", "");
			request.getSession(false).setAttribute("find", true);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AccountantHome.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AccountantHome.jsp");
		if (request.getParameter("type").equals("Student Details")) {

			request.setAttribute("type", "SD");

		} else if (request.getParameter("type").equals("Fee Details")) {

			request.setAttribute("type", "FD");

		} else if (request.getParameter("type").equals("Academic Details")) {

			request.setAttribute("type", "AD");

		} else if (request.getParameter("type").equals("Class Details")) {

			request.setAttribute("type", "CD");

		} else if (request.getParameter("type").equals("Find Student")) {

			request.setAttribute("type", "FS");

		} else if (request.getParameter("type").equals("Refresh Data")) {

			refreshData(request, response);
			request.setAttribute("type", "");

		}
		rd.forward(request, response);
	}

	private void refreshData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("getting data from DB");
			request.getSession(false).setAttribute("dataSD", service.getStudentDetails());
			request.getSession(false).setAttribute("dataFD", service.getFeeDetails());
			request.getSession(false).setAttribute("dataAD", service.getAcademicDetails());
			request.getSession(false).setAttribute("dataCD", service.getClassDetails());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
