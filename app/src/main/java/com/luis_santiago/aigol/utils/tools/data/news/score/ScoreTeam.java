package com.luis_santiago.aigol.utils.tools.data.news.score;

/**
 * Created by legendarywicho on 8/12/17.
 */

public class ScoreTeam {
    private String slugRound;
    private String finalScore;
    private String teamAway;
    private String teamAwayLogo;
    private String team_home;
    private String team_home_logo;

    public ScoreTeam(String round, String finalScore, String teamAway, String teamAwayLogo, String team_home, String team_home_logo) {
        this.slugRound = round;
        this.finalScore = finalScore;
        this.teamAway = teamAway;
        this.teamAwayLogo = teamAwayLogo;
        this.team_home = team_home;
        this.team_home_logo = team_home_logo;
    }

    public String getSlugRound() {
        return slugRound;
    }

    public String getTeamAway() {
        return teamAway;
    }

    public String getTeamAwayLogo() {
        return teamAwayLogo;
    }

    public String getTeam_home() {
        return team_home;
    }

    public String getTeam_home_logo() {
        return team_home_logo;
    }

    public String getFinalScore() {
        return finalScore;
    }
}
