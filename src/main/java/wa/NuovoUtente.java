package wa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NuovoUtente
 * @author marco
 */
@WebServlet("/NuovoUtente")
public class NuovoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT = "INSERT INTO utenti(nome_utente, password_utente) VALUES (?, ?)";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		try {
			Connection conn = Connector.getConnection(); //
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, user);
			ps.setString(2, password);
			

		} catch (SQLException se) {
			se.printStackTrace();
		}
		RequestDispatcher rs = request.getRequestDispatcher("index.html");
		rs.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
