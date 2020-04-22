package wa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/ServletCarrello")
public class ServletCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/blue")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String vino = request.getParameter("vino");
		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Effettua il login prima di procedere all'acquisto.</font>");
			rd.include(request, response);
		} else {
			try (VinoDao dao = new VinoDao(ds)) {

				if (session.getAttribute("carrello") instanceof List<?>) {
					List<Vino> lista = (List<Vino>) session.getAttribute("carrello");					
					session.setAttribute("carrello", dao.carrello(vino, lista) );
					//to carrello.jsp
					RequestDispatcher rdc = getServletContext().getRequestDispatcher("/Carrello.jsp");
					rdc.forward(request, response);
					//to vino.jsp
					RequestDispatcher rdv = getServletContext().getRequestDispatcher("/Vino.jsp");
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Vino aggiunto al carrello correttamente.</font>");
					rdv.include(request, response);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/Vino.jsp");
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Qualcosa è andato storto.</font>");
					rd.include(request, response);
				}
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
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
