package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pokemon {

    private int id;
    private String name;
    @JsonProperty("base_experience")
    private int baseExperience;

    private int height;
    private int weight;

    @JsonProperty("is_default")
    private boolean isDefault;

    private Sprites sprites;

    private List<TypeSlot> types;

    private List<MoveSlot> moves;

    private List<Form> forms;

    private List<Stat> stats;

    private PokemonDetail pokemonDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<TypeSlot> getTypes() {
        return types;
    }

    public void setTypes(List<TypeSlot> types) {
        this.types = types;
    }

    public List<MoveSlot> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveSlot> moves) {
        this.moves = moves;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public PokemonDetail getPokemonDetail() {
        return pokemonDetail;
    }

    public void setPokemonDetail(PokemonDetail pokemonDetail) {
        this.pokemonDetail = pokemonDetail;
    }

    public void setColor(PokemonColor color) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
