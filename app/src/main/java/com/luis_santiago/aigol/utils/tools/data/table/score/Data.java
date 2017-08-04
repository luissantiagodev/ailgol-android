package com.luis_santiago.aigol.utils.tools.data.table.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.*;

/**
 * Created by legendarywicho on 8/1/17.
 */

public class Data {
    @SerializedName("standings")
    @Expose
    private List<Standing> standings = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("statusReason")
    @Expose
    private String statusReason;

    public List<Standing> getStandings() {
        return standings;
    }

    public void setStandings(List<Standing> standings) {
        this.standings = standings;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
}
