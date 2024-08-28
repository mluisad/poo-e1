import java.util.ArrayList;

public class Candidatura {
	private ArrayList<Candidato> candidatos;


	public Candidatura(){
	candidatos = new ArrayList<>();
	}

	public boolean cadastraCandidato(Candidato c) {
		return false;
	}

	public Candidato consultaCandidato(String nome){
		for(Candidato c : candidatos){
			if(c.getNome().equals(nome))
			return c;
		}
		return null;
	}

	public Candidato consultaCandidato(int numero){
		for(Candidato c : candidatos){
			if(c.getNumero() == numero)
			return c;
		}
		return null;
	}
}
