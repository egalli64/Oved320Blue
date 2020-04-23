package wa;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class NuovoUtente
 * 
 * @author marco
 */
@WebServlet("/utente/nuovo")
public class NuovoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/blue")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NuovoUtente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");

		try (UtenteDao dao = new UtenteDao(ds)) {
			Utente ut = new Utente(user, password);
			dao.save(ut);
			HttpSession session = request.getSession();
			session.setAttribute("user", ut);
			request.setAttribute("user", ut);

			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
			rs.forward(request, response);
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
