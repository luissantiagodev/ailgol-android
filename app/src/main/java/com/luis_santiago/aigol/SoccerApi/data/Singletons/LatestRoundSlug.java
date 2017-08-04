package com.luis_santiago.aigol.SoccerApi.data.Singletons;

import android.util.Log;

import com.luis_santiago.aigol.utils.tools.data.table.score.DateScoreLegue;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.*;

import static android.content.ContentValues.TAG;

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
        return ourInstance.getSlugRound(new DateTime().toLocalDate());
    }

    private LatestRoundSlug() {
        //TODO: store this in a table database
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("08/18/2017"), convertStringtoDate("08/24/2017"),1)); // Round 1
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("08/25/2017"), convertStringtoDate("08/28/2017"),2)); // Round 2
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("09/08/2017"), convertStringtoDate("09/10/2017"),3)); // Round 3
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("09/15/2017"), convertStringtoDate("09/17/2017"),4)); // Round 4
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("09/19/2017"), convertStringtoDate("09/20/2017"),5)); // Round 5
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("09/22/2017"), convertStringtoDate("09/24/2017"),6)); // Round 6
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("09/28/2017"), convertStringtoDate("10/1/2017"),7)); // Round 7
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("10/2/2017"), convertStringtoDate("10/18/2017"),8)); // Round 8
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("10/22/2017"), convertStringtoDate("10/28/2017"),9)); // Round 9
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("10/29/2017"), convertStringtoDate("11/4/2017"),10)); // Round 10
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("11/5/2017"), convertStringtoDate("11/18/2017"),11)); // Round 11
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("11/19/2017"), convertStringtoDate("11/25/2017"),12)); // Round 12
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("11/26/2017"), convertStringtoDate("12/03/2017"),13)); // Round 13
        mDateScoreLegues.add(new DateScoreLegue(convertStringtoDate("12/04/2017"), convertStringtoDate("12/10/2017"),14)); // Round 14
      }

    private int getSlugRound(LocalDate currentDate){
        for(int i = 0; i<mDateScoreLegues.size(); i++){
            DateScoreLegue d = mDateScoreLegues.get(i);
            // If my current date is between one of these rounds then we will show that round
            if(!d.getmFrom().isAfter(currentDate) && !d.getmFrom().isAfter(d.getmTo())){
                // Return the round slug
                Log.e(TAG, "I've sent the round slug");
                return d.getRoundSlug();
            }
        }
        // If we don't get nothing, return 0
        return 0;
    }

    private LocalDate convertStringtoDate(String date){
        // Converting a  String into dateTime using Yoda Time
        String carl [];
        carl = date.split("/");
        LocalDate localDate = new DateTime(Integer.parseInt(carl[2]), Integer.parseInt(carl[0]),
                Integer.parseInt(carl[1]),0,0,0,0).toLocalDate();
        return localDate;
    }
}
