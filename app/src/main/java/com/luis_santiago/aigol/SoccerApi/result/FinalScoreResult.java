package com.luis_santiago.aigol.SoccerApi.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.luis_santiago.aigol.utils.tools.data.latest.score.Data;

/**
 * Created by legendarywicho on 8/3/17.
 */

public class FinalScoreResult {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
