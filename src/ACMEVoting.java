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
			BufferedReader streamEntrada = new BufferedReader(new FileReader("input.txt"));
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
	}	

	public void cadastrarPartidos(){
		int numero = in.nextInt();
		while(numero != -1){
			in.nextLine();
			String nome = in.nextLine();
			Partido p = new Partido(numero, nome);
			cadastroPartido.cadastraPartido(p);
			System.out.println("1:" + p.getNumero() + "," + p.getNome());
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
			System.out.println("2:" + c.getNumero() + "," + c.getNome() + "," + c.getMunicipio());
			candidatura.cadastraCandidato(c);
			numero = in.nextInt();
		}
	}
}
