package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Showdown {

    @JsonProperty("front_default")
    private String frontDefault;

    @JsonProperty("front_shiny")
    private String frontShiny;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

}
