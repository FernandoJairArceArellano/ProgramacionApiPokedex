package com.Digis01.FArceConsumoPokeAPI.ML;

import java.util.List;

public class MoveSlot {

    private Move move;
    private MoveData moveData;
    private List<VersionGroupDetail> version_group_details;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public MoveData getMoveData() {
        return moveData;
    }

    public void setMoveData(MoveData moveData) {
        this.moveData = moveData;
    }

    public List<VersionGroupDetail> getVersion_group_details() {
        return version_group_details;
    }

    public void setVersion_group_details(List<VersionGroupDetail> version_group_details) {
        this.version_group_details = version_group_details;
    }

}
