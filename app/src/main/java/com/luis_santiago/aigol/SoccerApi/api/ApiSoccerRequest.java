package com.luis_santiago.aigol.SoccerApi.api;

import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;

import retrofit2.http.GET;

/**
 * Created by legendarywicho on 7/31/17.
 */

public interface ApiSoccerRequest {
    // Getting the general news of Soccer news
    @GET("articles?source=bbc-sport&sortBy=top&apiKey=2c6a0749df6b4979a019d79be5153b1d")
    rx.Observable<NewsFinalResult> getLatestNews();
}
