package com.Digis01.FArceConsumoPokeAPI.ML;

import java.util.List;

public class PokemonResponse {

    private int count;
    private String next;
    private String previous;
    private List<PokemonSummary> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonSummary> getResults() {
        return results;
    }

    public void setResults(List<PokemonSummary> results) {
        this.results = results;
    }

}
