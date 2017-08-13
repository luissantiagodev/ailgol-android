package com.luis_santiago.aigol;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.luis_santiago.aigol.utils.tools.adapters.LeagueAdapter;
import com.luis_santiago.aigol.utils.tools.data.news.score.LeagueTeam;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    // This is to set up our recyclewview into a grid
    private GridLayoutManager mGridLayoutManager;
    private int number;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Log.v("Main activity","Permission: "+permissions[0]+ "was "+grantResults[0]);
            Toast.makeText(this, "I GOT PERMISSION", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        // I pass the context and the number of columns in the grid view
        mGridLayoutManager = new GridLayoutManager(this, 2);
        // I assing my LayoutManager for a grid view
        recyclerView.setLayoutManager(mGridLayoutManager);
        ArrayList<LeagueTeam> finalLeague = new ArrayList<>();

        /*
        * Because I only have some leagues on the API, I'm going to make it static
        * */
        finalLeague.add(new LeagueTeam(R.drawable.laliga_v_600x600, "LigaEspañola"));
        finalLeague.add(new LeagueTeam(R.drawable.mx_logo, "LigaMx"));
        finalLeague.add(new LeagueTeam(R.drawable.liga_francesa, "Ligue1"));
        finalLeague.add(new LeagueTeam(R.drawable.endervise, "Eredivisie"));
        finalLeague.add(new LeagueTeam(R.drawable.bundesliga_logo, "bundesliga"));
        finalLeague.add(new LeagueTeam(R.drawable.liguea, "serie-a"));
        finalLeague.add(new LeagueTeam(R.drawable.premier, "premier-league"));

        LeagueAdapter leagueAdapter = new LeagueAdapter(finalLeague);
        // I set up the adapter to run everything
        recyclerView.setAdapter(leagueAdapter);

        // Requesting the permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED) {
               // Do nothing for now
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, number);
            }
        }
    }
}
