import java.util.ArrayList;

public class Candidatura {
	private ArrayList<Candidato> candidatos;


	public Candidatura(){
		candidatos = new ArrayList<>();
	}

	public boolean cadastraCandidato(Candidato c) {
		if(!candidatos.isEmpty()){
			if(consultaCandidato(c.getNumero(), c.getMunicipio()) != null)
			return false;
		}

		candidatos.add(c);
		return true;
	}

	public Candidato consultaCandidato(int numero, String municipio){
		for (Candidato c : candidatos) {
			if(c.getNumero() == numero && c.getMunicipio().equals(municipio))
			return c;			
		}
		return null;
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

	public Candidato consultaMunicipio(String municipio){
		for(Candidato c : candidatos){
			if(c.getMunicipio().equals(municipio))
			return c;
		}
		return null;
	}

	public boolean cadastrarVotos(Candidato c, int votos){
		if(c == null){
			return false;
		} else {
			c.setVotos(votos);
			return true;
		}
	}

	public ArrayList<Candidato> getCandidatos(){
		return candidatos;
	}
}