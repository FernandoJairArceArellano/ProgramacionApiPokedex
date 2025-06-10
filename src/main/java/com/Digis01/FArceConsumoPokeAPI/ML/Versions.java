package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versions {

    @JsonProperty("generation-ix")
    private GenerationIX generationIX;

    public GenerationIX getGenerationIX() {
        return generationIX;
    }

    public void setGenerationIX(GenerationIX generationIX) {
        this.generationIX = generationIX;
    }
}
