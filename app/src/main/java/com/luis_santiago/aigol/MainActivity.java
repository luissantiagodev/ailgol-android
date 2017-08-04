package com.luis_santiago.aigol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.luis_santiago.aigol.utils.tools.adapters.LeagueAdapter;
import com.luis_santiago.aigol.utils.tools.data.table.score.LeagueTeam;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    // This is to set up our recyclewview into a grid
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        // I pass the context and the number of columns in the grid view
        mGridLayoutManager = new GridLayoutManager(this,2);
        // I assing my LayoutManager for a grid view
        recyclerView.setLayoutManager(mGridLayoutManager);
        ArrayList <LeagueTeam> finalLeague = new ArrayList<>();

        /*
        * Because I only have some leagues on the API, I'm going to make it static
        * */
        finalLeague.add(new LeagueTeam(R.drawable.laliga_v_600x600,"liga"));
        finalLeague.add(new LeagueTeam(R.drawable.liga_francesa,"ligue1"));
        finalLeague.add(new LeagueTeam(R.drawable.endervise,"Eredivisie"));
        finalLeague.add(new LeagueTeam(R.drawable.bundesliga_logo,"bundesliga"));
        finalLeague.add(new LeagueTeam(R.drawable.liguea,"serie-a"));
        finalLeague.add(new LeagueTeam(R.drawable.premier,"premier-league"));
        finalLeague.add(new LeagueTeam(R.drawable.logo_serie_b,"serie-b"));

        LeagueAdapter leagueAdapter  = new LeagueAdapter(finalLeague);
        // I set up the adapter to run everything
        recyclerView.setAdapter(leagueAdapter);

    }

}
