package com.Digis01.FArceProgramacionConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIX {

    @JsonProperty("scarlet-violet")
    private ScarletViolet scarletViolet;

    public ScarletViolet getScarletViolet() {
        return scarletViolet;
    }

    public void setScarletViolet(ScarletViolet scarletViolet) {
        this.scarletViolet = scarletViolet;
    }
}
