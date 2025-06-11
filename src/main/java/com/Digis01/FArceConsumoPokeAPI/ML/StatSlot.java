package com.Digis01.FArceConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatSlot {

    @JsonProperty("base_stat")
    private int baseStat;
    private int effort;
    private Stat stat;
    private String statIconUrl;

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getStatIconUrl() {
        return statIconUrl;
    }

    public void setStatIconUrl(String statIconUrl) {
        this.statIconUrl = statIconUrl;
    }

}
