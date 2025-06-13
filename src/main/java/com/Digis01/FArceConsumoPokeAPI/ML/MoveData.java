package com.Digis01.FArceConsumoPokeAPI.ML;

public class MoveData {

    private int id;
    private String name;
    private int power;
    private int pp;
    private int accuracy;
    private MoveType type;
    private MoveDamageClass damage_class;

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public MoveType getType() {
        return type;
    }

    public void setType(MoveType type) {
        this.type = type;
    }

    public MoveDamageClass getDamage_class() {
        return damage_class;
    }

    public void setDamage_class(MoveDamageClass damage_class) {
        this.damage_class = damage_class;
    }

}
