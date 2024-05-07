package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DadoSerie(@JsonAlias("title") String title,
                        @JsonAlias("seanso") Integer totalTemporadas,
                        @JsonAlias("imdbRating") String avaliacao) {
}