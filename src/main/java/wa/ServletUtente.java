package wa;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ServletUtente
 */
@WebServlet("/html/login")
public class ServletUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET_BY_NAME = "SELECT nome_utente, password_utente FROM utenti WHERE nome_utente = ? and password_utente= ?";

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");

		if (checkUser(user, password) == true) {
			HttpSession session = request.getSession();
			session.setAttribute(user, password);
			request.setAttribute("user", user);
			request.setAttribute("password", password);
			
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);			
			RequestDispatcher rs = request.getRequestDispatcher("/AccessoConfermato.jsp");
			rs.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Reception.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Username o password errati.</font>");
			rd.include(request, response);
			
			
		}

	}

}






