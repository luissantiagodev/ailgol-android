package com.luis_santiago.aigol.utils.tools.data.news.score;

/**
 * Created by legendarywicho on 8/10/17.
 */

public class TableTeam {
    private String position;
    private String logo;
    private String name;
    private String mp;
    private String gf;
    private String ga;
    private String gd;
    private String pts;

    public TableTeam(String position, String logo, String name, String mp, String gf, String ga, String gd, String pts) {
        this.position = position;
        this.logo = logo;
        this.name = name;
        this.mp = mp;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
        this.pts = pts;
    }

    public String getPosition() {
        return position;
    }

    public String getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getMp() {
        return mp;
    }

    public String getGf() {
        return gf;
    }

    public String getGa() {
        return ga;
    }

    public String getGd() {
        return gd;
    }

    public String getPts() {
        return pts;
    }

    @Override
    public String toString() {
        return "TableTeam{" +
                "position='" + position + '\'' +
                ", logo='" + logo + '\'' +
                ", name='" + name + '\'' +
                ", mp='" + mp + '\'' +
                ", gf='" + gf + '\'' +
                ", ga='" + ga + '\'' +
                ", gd='" + gd + '\'' +
                ", pts='" + pts + '\'' +
                '}';
    }
}
