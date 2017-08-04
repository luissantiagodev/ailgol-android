package com.luis_santiago.aigol.SoccerApi.data.Singletons;

import android.support.annotation.NonNull;


import com.google.gson.Gson;
import com.luis_santiago.aigol.SoccerApi.api.ApiSoccerRequest;
import com.luis_santiago.aigol.SoccerApi.result.FinalResultSoccerTable;
import com.luis_santiago.aigol.SoccerApi.result.FinalScoreResult;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by legendarywicho on 7/31/17.
 */

public class AilGolClient {

    /**
     * Getting an instance of the Api class and Ailgol Client Class
     */
    private static AilGolClient mAilGolClient;
    private static ApiSoccerRequest mApiSoccerRequest;


    private AilGolClient(){


        //Setting up retrofit with the builder
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Keys.URL_BASE_TABLE_STANDINGS)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        // I get my Api interface to start the request
        // To understand this better, is like creating a classic intent
        mApiSoccerRequest = retrofit.create(ApiSoccerRequest.class);
    }

    public static AilGolClient getInstance(){
        if(mAilGolClient == null){
            mAilGolClient = new AilGolClient();
        }
        return mAilGolClient;
    }

    // This is for the season tables for position
    public rx.Observable<FinalResultSoccerTable> getTeamLeagues(@NonNull String leagueName){
        return mApiSoccerRequest.getStandingsLegue(leagueName);
    }

    // This is for the latest results
    public rx.Observable<FinalScoreResult> getLatestResults(@NonNull String roundSlug, String league){
        return  mApiSoccerRequest.getLatestResult(roundSlug, league);
    }

}
