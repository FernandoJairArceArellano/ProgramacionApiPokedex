package com.Digis01.FArceConsumoPokeAPI.ML;

public class PokemonSpecies {

    private PokemonColor color;
    private EvolutionChain evolution_chain;

    // getters y setters
    public PokemonColor getColor() {
        return color;
    }

    public void setColor(PokemonColor color) {
        this.color = color;
    }

    public EvolutionChain getEvolution_chain() {
        return evolution_chain;
    }

    public void setEvolution_chain(EvolutionChain evolution_chain) {
        this.evolution_chain = evolution_chain;
    }

    public static class EvolutionChain {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
