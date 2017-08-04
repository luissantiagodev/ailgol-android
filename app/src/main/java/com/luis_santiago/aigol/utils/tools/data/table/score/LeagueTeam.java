package com.luis_santiago.aigol.utils.tools.data.table.score;

/**
 * Created by legendarywicho on 7/28/17.
 */

public class LeagueTeam {

    private int imageDrawable;
    private String leagueName;


    public LeagueTeam(int logo, String name){
        this.imageDrawable = logo;
        this.leagueName = name;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public String getLeagueName() {
        return leagueName;
    }
}
