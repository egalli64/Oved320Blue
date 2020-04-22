package wa;

public class Acquisti {
	
	private int acquisto_id;
	private int utente_id;
	private int prodotto_id;
	private double data_e_ora;
	
	public Acquisti() {
		}
	
	public Acquisti(int acquisto_id, int utente_id, int prodotto_id, double data_e_ora ) {
		this.acquisto_id=acquisto_id;
		this.utente_id=utente_id;
		this.prodotto_id=prodotto_id;
		this.data_e_ora=data_e_ora;
	}

	public int getAcquisto_id() {
		return acquisto_id;
	}

	public void setAcquisto_id(int acquisto_id) {
		this.acquisto_id = acquisto_id;
	}

	public int getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(int utente_id) {
		this.utente_id = utente_id;
	}

	public int getProdotto_id() {
		return prodotto_id;
	}

	public void setProdotto_id(int prodotto_id) {
		this.prodotto_id = prodotto_id;
	}

	public double getData_e_ora() {
		return data_e_ora;
	}

	public void setData_e_ora(double data_e_ora) {
		this.data_e_ora = data_e_ora;
	}
	
}
