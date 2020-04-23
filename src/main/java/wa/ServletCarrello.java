package wa;

import java.io.IOException;


import java.util.HashSet;
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
				Set<Vino> set = (Set<Vino>) session.getAttribute("carrello");
				if (set == null) {
					set = new HashSet<Vino>();
				}	
			    int order = Integer.parseInt(request.getParameter("order"));
				Vino item = (Vino) session.getAttribute("vino");
				//try (VinoDao dao = new VinoDao(ds)){
				//dao.updateStock(order, item.getId(), item);}
				
				item.setOrdini(order+item.getOrdini());
				item.setStock(item.getStock()-order);
				set.add(item);
				session.setAttribute("carrello", set);
				RequestDispatcher rdv = getServletContext().getRequestDispatcher("/Vino.jsp");
				request.setAttribute("message", "Vino aggiunto al carrello");
				rdv.forward(request, response);
				
			} catch (Exception e) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Vino.jsp");
				request.setAttribute("error", "Qualcosa Ã¨ andato storto");
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