package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadoSerie;
import br.com.alura.screenmatch.model.DadosEpsodios;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados() ;

    private final String ENDERECO = "http://www.omdbapi.com/?i=";
    private final String API_KEY = "tt3896198&apikey=c49c2745" ;

    public void exibeMenu(){

        System.out.println("Digite o nome da série para ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadoSerie dados = conversor.obterDados(json,DadoSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas() ; i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&seanson=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

    }
}
