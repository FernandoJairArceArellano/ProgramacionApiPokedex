package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {

    @JsonProperty("front_default")
    private String frontDefault;

    @JsonProperty("front_shiny")
    private String frontShiny;

    private Versions versions;

    private Generation generation;

    private Other other;

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

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

}
