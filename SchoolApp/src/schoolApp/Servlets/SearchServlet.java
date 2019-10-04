package schoolApp.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.poc.services.AccountantServices;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7584346785560161075L;
	private AccountantServices service;

	public SearchServlet() {
		service = new AccountantServices();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get sending search jsp");
		RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
		String key = req.getParameter("key");
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
			req.setAttribute("key", "");
			rd.forward(req, resp);
		} else {
			try {
				System.out.println("executing qury");
				req.setAttribute("search", service.findStudent(id, key));
				req.setAttribute("key", key);
				rd.forward(req, resp);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post sending search jsp");
		req.setAttribute("key", "");
		RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
		rd.include(req, resp);
	}
}
