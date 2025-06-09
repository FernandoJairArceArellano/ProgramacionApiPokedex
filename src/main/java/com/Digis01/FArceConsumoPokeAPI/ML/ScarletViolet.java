package com.Digis01.FArceProgramacionConsumoPokeAPI.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScarletViolet {

    @JsonProperty("name_icon")
    private String nameIcon;

    public String getNameIcon() {
        return nameIcon;
    }

    public void setNameIcon(String nameIcon) {
        this.nameIcon = nameIcon;
    }

}
