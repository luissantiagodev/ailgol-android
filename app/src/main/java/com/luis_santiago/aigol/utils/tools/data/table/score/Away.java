package com.luis_santiago.aigol.utils.tools.data.table.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 8/1/17.
 */

public class Away {
    @SerializedName("wins")
    @Expose
    private Integer wins;
    @SerializedName("draws")
    @Expose
    private Integer draws;
    @SerializedName("losts")
    @Expose
    private Integer losts;
    @SerializedName("scores")
    @Expose
    private Integer scores;
    @SerializedName("conceded")
    @Expose
    private Integer conceded;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("last_5")
    @Expose
    private String last5;
    @SerializedName("matches_played")
    @Expose
    private Integer matchesPlayed;
    @SerializedName("goal_difference")
    @Expose
    private Integer goalDifference;

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getLosts() {
        return losts;
    }

    public void setLosts(Integer losts) {
        this.losts = losts;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Integer getConceded() {
        return conceded;
    }

    public void setConceded(Integer conceded) {
        this.conceded = conceded;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getLast5() {
        return last5;
    }

    public void setLast5(String last5) {
        this.last5 = last5;
    }

    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

}
