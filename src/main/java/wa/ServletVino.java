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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletVino
 */
@WebServlet("/ServletVino")
public class ServletVino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVino() {
        super();
        // TODO Auto-generated constructor stub
    }

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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vino = request.getParameter("vino");
		
		try(VinoDao dao = new VinoDao(ds)){
			Optional<Vino> opt = dao.get(vino);
			if(dao.get(vino).isPresent()) {
				HttpSession session = request.getSession();
				session.setAttribute("vino", vino);
				request.setAttribute("vino", opt);
				RequestDispatcher rs = request.getRequestDispatcher("/Vino.jsp");
				rs.forward(request, response);
							}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>vino non trovato.</font>");
				rd.include(request, response);
			}
		}
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
