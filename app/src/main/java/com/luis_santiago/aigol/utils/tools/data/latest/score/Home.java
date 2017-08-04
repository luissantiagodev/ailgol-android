package com.luis_santiago.aigol.utils.tools.data.latest.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 8/3/17.
 */

public class Home {
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("goals")
    @Expose
    private Integer goals;
    @SerializedName("ball_possession")
    @Expose
    private Integer ballPossession;
    @SerializedName("goal_attempts")
    @Expose
    private Integer goalAttempts;
    @SerializedName("shots_on_goal")
    @Expose
    private Integer shotsOnGoal;
    @SerializedName("shots_off_goal")
    @Expose
    private Integer shotsOffGoal;
    @SerializedName("blocked_shots")
    @Expose
    private Integer blockedShots;
    @SerializedName("free_kicks")
    @Expose
    private Integer freeKicks;
    @SerializedName("corner_kicks")
    @Expose
    private Integer cornerKicks;
    @SerializedName("offsides")
    @Expose
    private Integer offsides;
    @SerializedName("throw_in")
    @Expose
    private Integer throwIn;
    @SerializedName("goalkeeper_saves")
    @Expose
    private Integer goalkeeperSaves;
    @SerializedName("fouls")
    @Expose
    private Integer fouls;
    @SerializedName("red_cards")
    @Expose
    private Integer redCards;
    @SerializedName("yellow_cards")
    @Expose
    private Integer yellowCards;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getBallPossession() {
        return ballPossession;
    }

    public void setBallPossession(Integer ballPossession) {
        this.ballPossession = ballPossession;
    }

    public Integer getGoalAttempts() {
        return goalAttempts;
    }

    public void setGoalAttempts(Integer goalAttempts) {
        this.goalAttempts = goalAttempts;
    }

    public Integer getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(Integer shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public Integer getShotsOffGoal() {
        return shotsOffGoal;
    }

    public void setShotsOffGoal(Integer shotsOffGoal) {
        this.shotsOffGoal = shotsOffGoal;
    }

    public Integer getBlockedShots() {
        return blockedShots;
    }

    public void setBlockedShots(Integer blockedShots) {
        this.blockedShots = blockedShots;
    }

    public Integer getFreeKicks() {
        return freeKicks;
    }

    public void setFreeKicks(Integer freeKicks) {
        this.freeKicks = freeKicks;
    }

    public Integer getCornerKicks() {
        return cornerKicks;
    }

    public void setCornerKicks(Integer cornerKicks) {
        this.cornerKicks = cornerKicks;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getThrowIn() {
        return throwIn;
    }

    public void setThrowIn(Integer throwIn) {
        this.throwIn = throwIn;
    }

    public Integer getGoalkeeperSaves() {
        return goalkeeperSaves;
    }

    public void setGoalkeeperSaves(Integer goalkeeperSaves) {
        this.goalkeeperSaves = goalkeeperSaves;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }
}
