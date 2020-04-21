package wa;


import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/utente/login")
public class ServletUtente extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");

		try (UtenteDao dao = new UtenteDao(ds)) {		
		

		if (dao.get(user).isPresent()) {
			HttpSession session = request.getSession();
			session.setAttribute(user, password);
			request.setAttribute("user", user);
			request.setAttribute("password", password);

			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			RequestDispatcher rs = request.getRequestDispatcher("/AccessoConfermato.jsp");
			rs.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Username o password errati.</font>");
			rd.include(request, response);
		}
		}

	}

}
