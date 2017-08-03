package com.luis_santiago.aigol.utils.tools.pojos;


import java.util.Date;


/**
 * Created by legendarywicho on 8/2/17.
 */

public class DateScoreLegue {

    Date mFrom;
    Date mTo;
    int roundSlug;

    public DateScoreLegue(Date mFrom, Date mTo, int round) {
        this.mFrom = mFrom;
        this.mTo = mTo;
        this.roundSlug = round;
    }

    public int getRoundSlug() {
        return roundSlug;
    }

    public Date getmFrom() {
        return mFrom;
    }

    public Date getmTo() {
        return mTo;
    }

}
