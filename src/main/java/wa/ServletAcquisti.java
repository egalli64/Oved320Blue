package wa;

import java.io.IOException;
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

/**
 * Servlet implementation class ServletAcquisti
 */
@WebServlet("/ServletAcquisti")
public class ServletAcquisti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/blue")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			request.setAttribute("error", "Effettua il login prima di procedere all'acquisto.");
//			out.println("<c:if test="${error}"><p class="mistake">${error}</font></p>"); // JSP
			rd.forward(request, response);
		} else {
			try (VinoDao dao = new VinoDao(ds)) {
				@SuppressWarnings("unchecked")
				List<Ordine> lista = (List<Ordine>) session.getAttribute("carrello");
				if (lista == null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/Carrello.jsp");
					request.setAttribute("error", "Non ci sono vini nel carrello");
					rd.forward(request, response);
				} else {
//					List<Vino> carrello = new ArrayList<>();
//					for (int item : lista) {
//						carrello.add(dao.get(item).get());
//					}
					request.setAttribute("acquisti", lista);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/Carrello.jsp");
					rd.forward(request, response);
					
				}

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
