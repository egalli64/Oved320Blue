package wa;

public class Vino {

	private String nome;
	private double prezzo;
	private int anno;
	private String tipo;
	private int prodotto_id;
	private int stock;
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Vino() {
		}
	
	public Vino(String nome, String tipo, int anno, double prezzo, int id, int stock) {
		this.nome=nome;
		this.prezzo=prezzo;
		this.anno=anno;
		this.tipo=tipo;
		this.prodotto_id=id;
		this.stock=stock;
	}
	
	public String getNome() {
		return nome;
	}
	public int getId() {
		return prodotto_id;
	}
	public void setId(int id) {
		this.prodotto_id=id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
