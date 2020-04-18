package wa;

import java.sql.*;
import java.util.Optional;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUtente
 */
@WebServlet("/ServletUtente")
public class ServletUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET_BY_NAME = "SELECT nome_utente, password_utente FROM utenti WHERE nome_utente = ? and password_utente= ?";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUtente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * 
	 * @author marco query sul database
	 * 
	 */
	public static boolean checkUser(String user, String password) {
		boolean accesso = false;
		try {
			Connection conn = Connector.getConnection(); //
			PreparedStatement ps = conn.prepareStatement(GET_BY_NAME);
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			accesso = rs.next();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return accesso;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");

		if (checkUser(user, password) == true) {
			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		} else {
			System.out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
