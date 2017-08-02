package com.luis_santiago.aigol.SoccerApi;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by legendarywicho on 7/31/17.
 */

public interface ApiSoccerRequest {

    // Getting the teams position on the Tables Fragment
    @GET("leagues/{league-slug}/seasons/17-18/standings?mashape-key=aSQCm3sGOxmshtcKn0a08CL7tRGFp1HLHROjsnV0X34F3IXFcX")
    rx.Observable<FinalResultSoccerTable> getStandingsLegue(@Path("league-slug") String league);


    //TODO: Getting the latest result on the specific League they request


    // TODO: Getting the general news of Soccer news
}
