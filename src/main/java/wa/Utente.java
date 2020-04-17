package wa;

public class Utente {

	private String nome;
	private String password;

	public Utente() {
	}

	public Utente(String nome, String password) {
		this.nome = nome;
		this.password = password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + ", password=" + password + "]";
	}

	public static void main(String[] args) {	
		Utente utente= new Utente("mario", "password");
		System.out.println(utente.toString());
	}

}
