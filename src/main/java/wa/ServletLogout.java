package wa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletUtente
 */
@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/blue")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		super.init();

		// resource injection not working in Tomcat latest versions (?!)
		if (ds == null) {
			// logger.info("Resource-not-injected Tomcat patch");
			try {
				Context envContext = (Context) (new InitialContext().lookup("java:/comp/env"));
				ds = (DataSource) envContext.lookup("jdbc/blue");
			} catch (NamingException ne) {
				throw new ServletException("Can't resolve JDBC resource", ne);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}
}