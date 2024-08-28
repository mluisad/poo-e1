public class Candidato {
	private Partido partido;
	private int numero;
	private String nome;
	private String municipio;
	private int votos;

	public Candidato(int numero, String nome, String municipio, Partido partido){
		this.numero = numero;
		this.nome = nome;
		this.municipio = municipio;
		this.partido = partido;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}
	
}
