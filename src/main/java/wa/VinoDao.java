package wa;

import java.io.Closeable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.sql.DataSource;

public class VinoDao implements Closeable {
	private Connection conn;
	private static final String GET_BY_NAME = "select p.nome, t.nome, p.anno, p.prezzo, p.prodotto_id, p.stock from prodotti p join tipi t using(tipo_id) where p.nome=?;";
	private static final String INSERT_DATA_SQL = "insert into acquisti(acquisto_id, utente_id, prodotto_id, data_e_ora)"
			+ "values (?, ?, ?, ?)";

	public VinoDao(DataSource ds) {

		try {
			this.conn = ds.getConnection();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

		
	public Optional<Vino> get(String nome) {
		try (Statement stmt = conn.createStatement(); //
				PreparedStatement ps = conn.prepareStatement(GET_BY_NAME)) {
			ps.setString(1, nome);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Vino my = new Vino(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
					return Optional.of(my);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return Optional.empty();
	}

	

	public void insertData(int acquisto_id, int utente_id, int prodotto_id, double data_e_ora) {
		try (Statement stmt = conn.createStatement(); //
				PreparedStatement ps = conn.prepareStatement(INSERT_DATA_SQL)) {
			ps.setInt(1, acquisto_id);
			ps.setInt(2, utente_id);
			ps.setInt(3, prodotto_id);
			ps.setDouble(4, data_e_ora);

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
}
