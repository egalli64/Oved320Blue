package wa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
				Set<Vino> carrello = (Set<Vino>) session.getAttribute("carrello");
				if (carrello == null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/Carrello.jsp");
					request.setAttribute("error", "Non ci sono vini nel carrello");
					rd.forward(request, response);
				} else {
//					List<Vino> carrello = new ArrayList<>();
			/*		List<Vino> carrello= new ArrayList<Vino>();
					for (int j=0; j<lista.size(); j++) {
						Vino item= lista.get(j);
						int count=item.getOrdini();
						for (int i=j+1; i<lista.size(); i++) {
							if(lista.get(i).getId()==item.getId()) {
								count=+lista.get(i).getOrdini();
								item.setOrdini(count);
							}
						}
						carrello.add(item);
					}*/
					request.setAttribute("acquisti", carrello);
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
