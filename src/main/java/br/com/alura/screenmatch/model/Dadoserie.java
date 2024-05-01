package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record Dadoserie(@JsonAlias("title") String title,
                        @JsonAlias("totalseanso") Integer totalTemporadas,
                        @JsonAlias("imdbRating") String avaliacao) {
}
