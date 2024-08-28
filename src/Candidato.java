public class Candidato {
	private int numero;
	private String nome;
	private String municipio;
	private int votos;

	public Candidato(int numero, String nome, String municipio){
		this.numero = numero;
		this.nome = nome;
		this.municipio = municipio;
		votos = 0;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public int getVotos() {
		return votos;
	}
	
}
