package com.luis_santiago.aigol.utils.tools.data.latest.score;

import com.google.gson.annotations.Expose;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 8/3/17.
 */

public class Data {
    @SerializedName("matches")
    @Expose
    private List<Match> matches = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("statusReason")
    @Expose
    private String statusReason;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
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
