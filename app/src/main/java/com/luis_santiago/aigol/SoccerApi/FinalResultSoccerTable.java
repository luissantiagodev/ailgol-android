package com.luis_santiago.aigol.SoccerApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.luis_santiago.aigol.SoccerApi.data.Data;

/**
 * Created by legendarywicho on 8/1/17.
 */

public class FinalResultSoccerTable {
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
