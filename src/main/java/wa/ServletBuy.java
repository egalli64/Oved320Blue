package wa;

import java.io.IOException;
import java.sql.SQLException;
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


@WebServlet("/ServletBuy")
public class ServletBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/blue")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*	Utente utente= (Utente) session.getAttribute("utente");
		try (UtenteDao daoUtente = new UtenteDao(ds)){
			daoUtente.get(utente.getNome(), utente.getPassword());
	}	*/
		Set<Vino> carrello = (Set<Vino>) session.getAttribute("carrello");
		if (carrello == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Carrello.jsp");
			request.setAttribute("error", "Non ci sono vini nel carrello");
			rd.forward(request, response);
		}
		else {
			for (Vino item:carrello) {
				try (VinoDao dao = new VinoDao(ds)){
					
				dao.updateStock(item);
				//dao.insertData(utente.getId(), prodotto_id, data_e_ora);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
			carrello=null;
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Carrello.jsp");
			request.setAttribute("message", "L'acquisto Ã¨ andato a buon fine! Grazie per aver scelto SoulWine! Salute!");
			rd.forward(request, response);
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}