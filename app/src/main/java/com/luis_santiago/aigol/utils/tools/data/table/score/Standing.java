package com.luis_santiago.aigol.utils.tools.data.table.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 8/1/17.
 */

public class Standing {
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("team_identifier")
    @Expose
    private String teamIdentifier;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("overall")
    @Expose
    private Overall overall;
    @SerializedName("home")
    @Expose
    private Home home;
    @SerializedName("away")
    @Expose
    private Away away;
    @SerializedName("penalization_points")
    @Expose
    private Integer penalizationPoints;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeamIdentifier() {
        return teamIdentifier;
    }

    public void setTeamIdentifier(String teamIdentifier) {
        this.teamIdentifier = teamIdentifier;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Overall getOverall() {
        return overall;
    }

    public void setOverall(Overall overall) {
        this.overall = overall;
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

    public Integer getPenalizationPoints() {
        return penalizationPoints;
    }

    public void setPenalizationPoints(Integer penalizationPoints) {
        this.penalizationPoints = penalizationPoints;
    }
}
