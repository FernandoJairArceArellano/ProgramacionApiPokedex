package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PokemonDetail {

    private int id;
    private String name;

    @JsonProperty("sprites")
    private Sprites sprites;

    private List<TypeSlot> types;

    // Getters y Setters
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

    public static class Sprites {

        @JsonProperty("front_default")
        private String frontDefault;

        // Getters y Setters
        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }
    }

    public static class TypeSlot {

        private Type type;

        // Getters y Setters
        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    public static class Type {

        private String name;

        // Getters y Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
