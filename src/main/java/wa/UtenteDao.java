package wa;

import java.sql.Connection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;


public class UtenteDao implements Closeable  {
   // private static final Logger logger = LoggerFactory.getLogger(UtenteDao.class);
    private Connection conn;
	private static final String GET_BY_NAME = "SELECT utente_id, nome_utente, password_utente FROM utenti WHERE nome_utente = ?";
    private static final String GET_ALL = "SELECT utente_id, nome_utente, password_utente FROM utenti";
    private static final String INSERT = "INSERT INTO utenti(nome_utente, password_utente) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE utenti SET nome_utente = ?, password_utente = ?"
            + "WHERE nome_utente = ?";
    private static final String DELETE = "DELETE FROM utenti WHERE utente_id = ?";

    public UtenteDao(DataSource ds) {

        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
    
    
    public List<Utente> getAll() {
        List<Utente> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(GET_ALL)) {
            while (rs.next()) {
                Utente utente = new Utente( rs.getString(2), rs.getString(3));
                results.add(utente);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return results;
    }

   
    public Optional<Utente> get(String nome) {
        try (Statement stmt = conn.createStatement(); //
                PreparedStatement ps = conn.prepareStatement(GET_BY_NAME)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Utente my = new Utente(rs.getString(2), rs.getString(3));
                    return Optional.of(my);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return Optional.empty();
    }

    
    public void save(Utente utente) {
        try (Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement(INSERT)) {
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getPassword());
            ps.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

   
    public void update(Utente utente) {
        try (Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getPassword());
            int count = ps.executeUpdate();
            if (count != 1) {
                System.out.println("Warning! Updated " + count + " lines for " + utente);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

   
    public void delete(String nome) {
        try (Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1, nome);
            int count = ps.executeUpdate();
            if (count != 1) {
                System.out.println("Warning! Deleted " + count + " lines for " + nome);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    @Override
    public void close() throws IOException {
        try {
            conn.close();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
}