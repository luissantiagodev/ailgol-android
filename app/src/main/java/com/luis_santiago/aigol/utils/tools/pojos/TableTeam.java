package com.luis_santiago.aigol.utils.tools.pojos;

/**
 * Created by legendarywicho on 7/31/17.
 */

public class TableTeam {

    private int position;
    private int logo;
    private int mp;
    private int gf;
    private int ga;
    private int pts;


    public TableTeam(int positiion, int logo, int mp, int gf, int ga, int pts) {
        this.position = positiion;
        this.logo = logo;
        this.mp = mp;
        this.gf = gf;
        this.ga = ga;
        this.pts = pts;
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
}
