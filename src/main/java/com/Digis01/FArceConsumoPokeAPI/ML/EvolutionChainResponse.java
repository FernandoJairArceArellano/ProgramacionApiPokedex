package com.Digis01.FArceConsumoPokeAPI.ML;

import java.util.List;

public class EvolutionChainResponse {

    private Chain chain;

    public Chain getChain() {
        return chain;
    }

    public void setChain(Chain chain) {
        this.chain = chain;
    }

    public static class Chain {

        private Species species;
        private List<Chain> evolves_to;

        // Getters y Setters
        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        public List<Chain> getEvolves_to() {
            return evolves_to;
        }

        public void setEvolves_to(List<Chain> evolves_to) {
            this.evolves_to = evolves_to;
        }
    }

    public static class Species {

        private String name;
        private String url;

        // Getters y Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
