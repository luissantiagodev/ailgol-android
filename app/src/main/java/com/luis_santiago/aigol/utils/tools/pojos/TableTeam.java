package com.luis_santiago.aigol.utils.tools.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by legendarywicho on 7/31/17.
 */

public class TableTeam {


    private int position;
    private int logo;
    private String teamName;
    private int mp;
    private int gf;
    private int ga;
    private int pts;


    public TableTeam(int positiion, int logo, int mp, int gf, int ga, int pts, String teamName) {
        this.position = positiion;
        this.logo = logo;
        this.mp = mp;
        this.gf = gf;
        this.ga = ga;
        this.pts = pts;
        this.teamName = teamName;
    }

    public int getPosition() {
        return position;
    }

    public int getLogo() {
        return logo;
    }

    public int getMp() {
        return mp;
    }

    public int getGf() {
        return gf;
    }

    public int getGa() {
        return ga;
    }

    public int getPts() {
        return pts;
    }

    public String getTeamName(){
        return teamName;
    }

    @Override
    public String toString() {
        return "TableTeam{" +
                "position=" + position +
                ", logo=" + logo +
                ", teamName='" + teamName + '\'' +
                ", mp=" + mp +
                ", gf=" + gf +
                ", ga=" + ga +
                ", pts=" + pts +
                '}';
    }
}
