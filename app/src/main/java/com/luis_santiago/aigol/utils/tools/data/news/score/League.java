package com.luis_santiago.aigol.utils.tools.data.news.score;

/**
 * Created by legendarywicho on 8/10/17.
 */

public class League {

    private int imageDrawable;
    private String leagueName;


    public League(int logo, String name){
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