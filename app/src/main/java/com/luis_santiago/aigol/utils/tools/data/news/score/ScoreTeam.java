package com.luis_santiago.aigol.utils.tools.data.news.score;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by legendarywicho on 8/12/17.
 */

public class ScoreTeam implements Parcelable {

    private State mState;
    private String key;
    private String slugRound;
    private String finalScore;
    private String teamAway;
    private String teamAwayLogo;
    private String team_home;
    private String team_home_logo;
    private String date;

    public ScoreTeam(String date, State state, String key, String round, String finalScore, String teamAway, String teamAwayLogo, String team_home, String team_home_logo) {
        this.date = date;
        this.mState = state;
        this.key = key;
        this.slugRound = round;
        this.finalScore = finalScore;
        this.teamAway = teamAway;
        this.teamAwayLogo = teamAwayLogo;
        this.team_home = team_home;
        this.team_home_logo = team_home_logo;
    }

    protected ScoreTeam(Parcel in) {
        key = in.readString();
        slugRound = in.readString();
        finalScore = in.readString();
        teamAway = in.readString();
        teamAwayLogo = in.readString();
        team_home = in.readString();
        team_home_logo = in.readString();
        date = in.readString();
    }

    public static final Creator<ScoreTeam> CREATOR = new Creator<ScoreTeam>() {
        @Override
        public ScoreTeam createFromParcel(Parcel in) {
            return new ScoreTeam(in);
        }

        @Override
        public ScoreTeam[] newArray(int size) {
            return new ScoreTeam[size];
        }
    };

    public String getDate() {
        return date;
    }

    public State getState() {
        return mState;
    }

    public String getKey() {
        return key;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(slugRound);
        parcel.writeString(finalScore);
        parcel.writeString(teamAway);
        parcel.writeString(teamAwayLogo);
        parcel.writeString(team_home);
        parcel.writeString(team_home_logo);
        parcel.writeString(date);
    }

    @Override
    public String toString() {
        return "ScoreTeam{" +
                "mState=" + mState +
                ", key='" + key + '\'' +
                ", slugRound='" + slugRound + '\'' +
                ", finalScore='" + finalScore + '\'' +
                ", teamAway='" + teamAway + '\'' +
                ", teamAwayLogo='" + teamAwayLogo + '\'' +
                ", team_home='" + team_home + '\'' +
                ", team_home_logo='" + team_home_logo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}