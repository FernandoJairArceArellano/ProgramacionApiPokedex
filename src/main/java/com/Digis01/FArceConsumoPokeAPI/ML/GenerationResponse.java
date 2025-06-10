package com.Digis01.FArceConsumoPokeAPI.ML;

import java.util.List;

public class GenerationResponse {

    private List<PokemonSpecies> pokemon_species;

    public List<PokemonSpecies> getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(List<PokemonSpecies> pokemon_species) {
        this.pokemon_species = pokemon_species;
    }

}
