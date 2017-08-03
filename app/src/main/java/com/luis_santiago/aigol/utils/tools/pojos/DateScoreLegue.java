package com.luis_santiago.aigol.utils.tools.pojos;


import org.joda.time.LocalDate;

import java.util.Date;


/**
 * Created by legendarywicho on 8/2/17.
 */

public class DateScoreLegue {

    LocalDate mFrom;
    LocalDate mTo;
    int roundSlug;

    public DateScoreLegue(LocalDate mFrom, LocalDate mTo, int round) {
        this.mFrom = mFrom;
        this.mTo = mTo;
        this.roundSlug = round;
    }

    public int getRoundSlug() {
        return roundSlug;
    }

    public LocalDate getmFrom() {
        return mFrom;
    }

    public LocalDate getmTo() {
        return mTo;
    }

}
