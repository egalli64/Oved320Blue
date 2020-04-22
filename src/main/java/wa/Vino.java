package wa;

public class Vino {

	private String nome;
	private double prezzo;
	private int anno;
	private String tipo;
	private int id;
	
	
	public Vino() {
		}
	
	public Vino(String nome, String tipo, int anno, double prezzo, int id ) {
		this.nome=nome;
		this.prezzo=prezzo;
		this.anno=anno;
		this.tipo=tipo;
		this.id=id;
	}
	
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
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
