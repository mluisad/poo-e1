import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMEVoting {
	private Scanner in = null;
    private PrintStream saidaPadrao = System.out;
	private Candidatura candidatura;
	private CadastroPartido cadastroPartido;

	public ACMEVoting() {
		candidatura = new Candidatura();
		cadastroPartido = new CadastroPartido();
		
		try{
			BufferedReader streamEntrada = new BufferedReader(new FileReader("input3.txt"));
			in = new Scanner(streamEntrada);
			PrintStream streamSaida = new PrintStream(new File("outputFinal.txt"), Charset.forName("UTF-8"));
			System.setOut(streamSaida);
		} catch(Exception e){
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);
		in.useLocale(Locale.ENGLISH);
    }

	public void executar() {
		cadastrarPartidos();
		cadastrarCandidatos();
		cadastrarVotosDeCandidatos();
		mostrarDadosDeUmDeterminadoPartido();
		mostrarDadosDeUmDeterminadoCandidato();
		mostrarVotosDosPrefeitosDeUmDeterminadoPartido();
		mostrarDadosDoPartidoComMaisCandidatos();
		mostrarDadosDePrefeitoEVereadorMaisVotados();
	}	

	public void cadastrarPartidos(){
		int numero = in.nextInt();
		while(numero != -1){
			in.nextLine();
			String nome = in.nextLine();
			Partido p = new Partido(numero, nome);
			if(cadastroPartido.cadastraPartido(p)){
				System.out.println("1:" + p.getNumero() + "," + p.getNome());
			}
			cadastroPartido.cadastraPartido(p);
			numero = in.nextInt();
		}
	}

	public void cadastrarCandidatos(){
		int numero = in.nextInt();
		while(numero != -1){
			in.nextLine();
			String nome = in.nextLine();
			String municipio = in.nextLine();
			Candidato c = new Candidato(numero, nome, municipio);
			if(candidatura.cadastraCandidato(c)){
				System.out.println("2:" + c.getNumero() + "," + c.getNome() + "," + c.getMunicipio());
			}
			candidatura.cadastraCandidato(c);
			numero = in.nextInt();
		}
	}

	public void cadastrarVotosDeCandidatos(){
		int numero = in.nextInt();
		while(numero != -1){
			in.nextLine();
			String municipio = in.nextLine();
			int votos = in.nextInt();
			if(candidatura.cadastrarVotos(candidatura.consultaCandidato(numero), votos)){
				System.out.println("3:" + numero + "," + municipio + "," + votos);
				candidatura.cadastrarVotos(candidatura.consultaCandidato(numero), votos);
			}
			numero = in.nextInt();
		}
	}

	public void mostrarDadosDeUmDeterminadoPartido(){
		int numero = in.nextInt();
		if(cadastroPartido.consultaPartido(numero) == null){
			System.out.println("4:Nenhum partido encontrado.");
		} else {
			//4:numero,nome
			System.out.println("4:" + numero + "," + cadastroPartido.consultaPartido(numero).getNome());
		}
	}

	public void mostrarDadosDeUmDeterminadoCandidato(){
		int numero = in.nextInt();
		in.nextLine();
		String municipio = in.nextLine();
		if(candidatura.consultaCandidato(numero, municipio) == null){
			System.out.println("5:Nenhum candidato encontrado.");
		} else{
			System.out.println("5:" + numero + "," + candidatura.consultaCandidato(numero, municipio).getNome() + "," + municipio + "," + candidatura.consultaCandidato(numero, municipio).getVotos());
		}
	}
	
	public void mostrarVotosDosPrefeitosDeUmDeterminadoPartido(){
		String nome = in.nextLine();
		if(cadastroPartido.consultaPartido(nome) == null){
			System.out.println("6:Nenhum partido encontrado.");
		} else {
			//6:nomepartido,númeroprefeito,nomeprefeito,municipio,votos
			for(Candidato c : candidatura.getCandidatos()){
				if(c.getNumero() == cadastroPartido.consultaPartido(nome).getNumero()){
					System.out.println("6:" + nome + "," + c.getNumero() + "," + c.getNome() + "," + c.getMunicipio() + "," + c.getVotos());
				}
			}
		}
	}

	public void mostrarDadosDoPartidoComMaisCandidatos(){
		int quantidadeDeCandidatos = 0;
		int quantidadeFinal = 0;
		Partido partidoComMaisCandidato = null;
		
		for(Partido p : cadastroPartido.getPartidos()){
			for(Candidato c : candidatura.getCandidatos()){
				String numeroPartido = Integer.toString(p.getNumero());
				String numeroCandidato = Integer.toString(c.getNumero());
				if(numeroCandidato.startsWith(numeroPartido)){
					quantidadeDeCandidatos++;
				}
			}
			if(quantidadeDeCandidatos > quantidadeFinal){
				partidoComMaisCandidato = p;
				quantidadeFinal = quantidadeDeCandidatos;
			}
			quantidadeDeCandidatos = 0;
		}
		
		if(partidoComMaisCandidato == null){
			System.out.println("7:Nenhum partido com candidatos.");
		} else {
			System.out.println("7:" + partidoComMaisCandidato.getNumero() + "," + partidoComMaisCandidato.getNome() + "," + quantidadeFinal);
		}			
	}	

	public void mostrarDadosDePrefeitoEVereadorMaisVotados(){

	}


}
