import java.util.ArrayList;
public class Partido {

	private ArrayList<Candidato> candidatos;
	private int numero;
	private String nome;
	private int votos;

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

	public int getVotos(){
		return votos;
	}

	public void adicionaCandidato(Candidato c) {
		candidatos.add(c);
	}

	public int retornarNumeroDeCandidatos(){
		int temp = 0;
		for(Candidato c : candidatos){
			temp++;
		}
		return temp;
	}

	public void cadastraVotos(int v){
		votos = votos + v;
	}
}
