package wa;

import java.io.IOException;

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
		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Vino.jsp");
			request.setAttribute("error", "Effettua il login prima di procedere all'acquisto.");
//			out.println("<c:if test="${error}"><p class="mistake">${error}</font></p>"); // JSP
			rd.forward(request, response);
		} else {
			try {
				@SuppressWarnings("unchecked")
				List<Vino> lista = (List<Vino>) session.getAttribute("carrello");
				if (lista == null) {
					lista = new ArrayList<Vino>();
				}	
			    int stock = (int) request.getAttribute("stock");
				Vino item = (Vino) session.getAttribute("vino");
				item.setStock(stock);
				lista.add(item);
				session.setAttribute("carrello", lista);
				RequestDispatcher rdv = getServletContext().getRequestDispatcher("/Vino.jsp");
				request.setAttribute("message", "Vino aggiunto al carrello");
				rdv.forward(request, response);
				
			} catch (Exception e) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Vino.jsp");
				request.setAttribute("error", "Qualcosa è andato storto");
				e.printStackTrace(); // log
				rd.forward(request, response);
			}
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
