package com.luis_santiago.aigol.SoccerApi.api;

import com.luis_santiago.aigol.SoccerApi.result.FinalResultSoccerTable;
import com.luis_santiago.aigol.SoccerApi.result.FinalScoreResult;
import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by legendarywicho on 7/31/17.
 */

public interface ApiSoccerRequest {

    // Getting the teams position on the Tables Fragment
    @GET("leagues/{league-slug}/seasons/17-18/standings?mashape-key=aSQCm3sGOxmshtcKn0a08CL7tRGFp1HLHROjsnV0X34F3IXFcX")
    rx.Observable<FinalResultSoccerTable> getStandingsLegue(@Path("league-slug") String league);


    //Getting the latest result on the specific League they request
    @GET("leagues/{league}/seasons/17-18/rounds/round-{number}/matches?mashape-key=aSQCm3sGOxmshtcKn0a08CL7tRGFp1HLHROjsnV0X34F3IXFcX")
    rx.Observable<FinalScoreResult> getLatestResult (@Path("number") String leagueSlug, @Path("league") String league);

    // Getting the general news of Soccer news
    @GET("articles?source=bbc-sport&sortBy=top&apiKey=2c6a0749df6b4979a019d79be5153b1d")
    rx.Observable<NewsFinalResult> getLatestNews();
}
