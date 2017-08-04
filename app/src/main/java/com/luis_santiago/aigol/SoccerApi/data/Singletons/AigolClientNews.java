package com.luis_santiago.aigol.SoccerApi.data.Singletons;

import com.google.gson.Gson;
import com.luis_santiago.aigol.SoccerApi.api.ApiSoccerRequest;
import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by legendarywicho on 8/4/17.
 */

public class AigolClientNews {
    /**
     * Getting an instance of the Api class and Ailgol Client Class
     */
    private static AigolClientNews mAilGolClient;
    private static ApiSoccerRequest mApiSoccerRequest;


    private AigolClientNews(){


        //Setting up retrofit with the builder
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Keys.URL_BASE_NEWS)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        // I get my Api interface to start the request
        // To understand this better, is like creating a classic intent
        mApiSoccerRequest = retrofit.create(ApiSoccerRequest.class);
    }

    public static AigolClientNews getInstance(){
        if(mAilGolClient == null){
            mAilGolClient = new AigolClientNews();
        }
        return mAilGolClient;
    }

    public Observable<NewsFinalResult> getLatestNews(){
        return mApiSoccerRequest.getLatestNews();
    }
}
