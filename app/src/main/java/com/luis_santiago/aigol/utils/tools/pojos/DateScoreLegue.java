package com.luis_santiago.aigol.utils.tools.pojos;


import java.util.Date;


/**
 * Created by legendarywicho on 8/2/17.
 */

public class DateScoreLegue {

    Date mFrom;
    Date mTo;
    Date currentDate;

    public DateScoreLegue(Date mFrom, Date mTo, Date currentDate) {
        this.mFrom = mFrom;
        this.mTo = mTo;
        this.currentDate = currentDate;
    }

    public Date getmFrom() {
        return mFrom;
    }

    public Date getmTo() {
        return mTo;
    }

    public Date getCurrentDate() {
        return currentDate;
    }
}
