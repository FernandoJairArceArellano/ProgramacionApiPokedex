package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    
    @JsonProperty("base_experience")
    private int baseExperience;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }
    
    
}
