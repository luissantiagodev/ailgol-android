package com.luis_santiago.aigol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.luis_santiago.aigol.Tools.adapters.LeagueAdapter;
import com.luis_santiago.aigol.start.lib.LeagueTeam;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridview);

        ArrayList <LeagueTeam> finalLeague = new ArrayList<>();

        finalLeague.add(new LeagueTeam(R.drawable.laliga_v_600x600));
        finalLeague.add(new LeagueTeam(R.drawable.liga_francesa));
        finalLeague.add(new LeagueTeam(R.drawable.endervise));
        finalLeague.add(new LeagueTeam(R.drawable.bundesliga_logo));
        finalLeague.add(new LeagueTeam(R.drawable.liguea));
        finalLeague.add(new LeagueTeam(R.drawable.premier));
        finalLeague.add(new LeagueTeam(R.drawable.logo_serie_b));


        LeagueAdapter leagueAdapter = new LeagueAdapter(this,finalLeague);

        gridView.setAdapter(leagueAdapter);

    }
}
