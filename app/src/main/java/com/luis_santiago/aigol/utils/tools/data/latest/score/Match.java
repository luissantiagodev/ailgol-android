package com.luis_santiago.aigol.utils.tools.data.latest.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 8/3/17.
 */

public class Match {

    @SerializedName("referees")
    @Expose
    private Referees referees;
    @SerializedName("stadium")
    @Expose
    private Stadium stadium;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("match_slug")
    @Expose
    private String matchSlug;
    @SerializedName("date_match")
    @Expose
    private String dateMatch;
    @SerializedName("home")
    @Expose
    private Home home;
    @SerializedName("away")
    @Expose
    private Away away;
    @SerializedName("match_result")
    @Expose
    private String matchResult;
    @SerializedName("match_result_first_time")
    @Expose
    private String matchResultFirstTime;
    @SerializedName("played")
    @Expose
    private Integer played;

    public Referees getReferees() {
        return referees;
    }

    public void setReferees(Referees referees) {
        this.referees = referees;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMatchSlug() {
        return matchSlug;
    }

    public void setMatchSlug(String matchSlug) {
        this.matchSlug = matchSlug;
    }

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Away getAway() {
        return away;
    }

    public void setAway(Away away) {
        this.away = away;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getMatchResultFirstTime() {
        return matchResultFirstTime;
    }

    public void setMatchResultFirstTime(String matchResultFirstTime) {
        this.matchResultFirstTime = matchResultFirstTime;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

}
