import java.util.ArrayList;

public class CadastroPartido {

	private ArrayList<Partido> partidos;
	public CadastroPartido(){
		partidos = new ArrayList<>();
	}

	public boolean cadastraPartido(Partido p) {
		if(consultaPartido(p.getNome()) != null){
			return false;
		}
		partidos.add(p);
		return true;
	}

	public Partido consultaPartido(String nome) {
		for(Partido p : partidos){
			if(p.getNome().equals(nome))
			return p;
		}
		return null;
	}

	public Partido consultaPartido(int numero) {
		for(Partido p : partidos){
			if(p.getNumero() == numero)
			return p;
		}
		return null;
	}

}
