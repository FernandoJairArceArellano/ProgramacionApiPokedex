package com.Digis01.FArceProgramacionConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {

    @JsonProperty("front_default")
    private String frontDefault;

    private Versions versions;

    private Generation generation;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
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

}
