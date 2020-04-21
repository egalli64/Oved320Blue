package wa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletVino
 */
@WebServlet("/ServletVino")
public class ServletVino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/blue")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametro = request.getParameter("vino");

		try (VinoDao dao = new VinoDao(ds)) {
			Optional<Vino> opt = dao.get(parametro);
			if (opt.isPresent()) {
				Vino vino = opt.get();
				HttpSession session = request.getSession();
				session.setAttribute("nomeVino", parametro);
				session.setAttribute("vino", vino);
				request.setAttribute("nome", vino.getNome());
				request.setAttribute("tipo", vino.getTipo());
				request.setAttribute("anno", vino.getAnno());
				request.setAttribute("prezzo", vino.getPrezzo());

				RequestDispatcher rs = request.getRequestDispatcher("/Vino.jsp");
				rs.forward(request, response);
			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>vino non trovato.</font>");
				rd.include(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
