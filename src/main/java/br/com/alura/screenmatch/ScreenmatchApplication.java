package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Dadoserie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?i=tt3896198&apikey=c49c2745");
		System.out.println(json);
		ConverteDados converso =new ConverteDados();
		Dadoserie dados = converso.obterDados(json , Dadoserie.class);
		System.out.println(dados);
	}
}
