package com.luis_santiago.aigol.SoccerApi.data.Singletons;

import com.luis_santiago.aigol.utils.tools.pojos.DateScoreLegue;

import java.util.*;
/**
 * Created by legendarywicho on 8/2/17.
 */

public class LatestRoundSlug {

    private static LatestRoundSlug ourInstance = null;
    private ArrayList<DateScoreLegue> mDateScoreLegues = new ArrayList<>();

    public static int  getInstance() {
        if(ourInstance == null){
            ourInstance = new LatestRoundSlug();
        }
        return ourInstance.getSlugRound();
    }

    private LatestRoundSlug() {
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 1
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 2
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 3
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 4
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 5
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 6
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 7
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 8
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 9
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 10
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 11
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 12
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 14
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 15
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 16
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 17
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 18
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 19
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 20
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 21
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 22
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 23
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 25
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 26
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 27
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 28
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 29
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 30
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 31
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 32
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 33
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 34
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 35
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 36
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 37
        mDateScoreLegues.add(new DateScoreLegue(new Date(), new Date(), new Date())); // Round 38

    }

    private int getSlugRound(){
        return 1;
    }

}
