import java.util.ArrayList;
public class Partido {

	private ArrayList<Candidato> candidatos;
	private int numero;
	private String nome;

	public Partido(int numero, String nome){
		this.numero = numero;
		this.nome = nome;
		candidatos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public void adicionaCandidato(Candidato c) {
		candidatos.add(c);
	}

}
