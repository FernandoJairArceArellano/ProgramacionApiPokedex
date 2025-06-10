package com.Digis01.FArceConsumoPokeAPI.ML;

import java.util.List;

public class PokemonListResponse {

    private List<PokemonListResult> results;

    public List<PokemonListResult> getResults() {
        return results;
    }

    public void setResults(List<PokemonListResult> results) {
        this.results = results;
    }
}
