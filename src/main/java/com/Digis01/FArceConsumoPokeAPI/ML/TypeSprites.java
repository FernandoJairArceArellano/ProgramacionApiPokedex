package com.Digis01.FArceProgramacionConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeSprites {

    @JsonProperty("generation-ix")
    private GenerationIX generationIX;

    public GenerationIX getGenerationIX() {
        return generationIX;
    }

    public void setGenerationIX(GenerationIX generationIX) {
        this.generationIX = generationIX;
    }

}
