package com.luis_santiago.aigol.SoccerApi.data.Singletons;

import android.support.annotation.NonNull;


import com.google.gson.Gson;
import com.luis_santiago.aigol.SoccerApi.ApiSoccerRequest;
import com.luis_santiago.aigol.SoccerApi.FinalResultSoccerTable;
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
        //Setting up Gson for the Json parsing


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Keys.URL_BASE_TABLE_STANDINGS)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        // I get my Api interface to start the request
        // To understand this better, is like if you create an intent
        mApiSoccerRequest = retrofit.create(ApiSoccerRequest.class);
    }

    public static AilGolClient getInstance(){
        if(mAilGolClient == null){
            mAilGolClient = new AilGolClient();
        }
        return mAilGolClient;
    }
    public rx.Observable<FinalResultSoccerTable> getTeamLeagues(@NonNull String leagueName){
        return mApiSoccerRequest.getStandingsLegue(leagueName);
    }
}
