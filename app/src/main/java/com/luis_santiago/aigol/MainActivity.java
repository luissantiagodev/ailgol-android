package com.luis_santiago.aigol;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.luis_santiago.aigol.utils.tools.adapters.LeagueAdapter;
import com.luis_santiago.aigol.utils.tools.data.news.score.League;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    // This is to set up our recyclewview into a grid
    private GridLayoutManager mGridLayoutManager;
    private final int MY_PERMISION_REQUEST = 1;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        setUpToolbar();
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Choose your league");
        // I pass the context and the number of columns in the grid view
        mGridLayoutManager = new GridLayoutManager(this, 2);
        // I assing my LayoutManager for a grid view
        recyclerView.setLayoutManager(mGridLayoutManager);
        ArrayList<League> finalLeague = new ArrayList<>();

        /*
        * Because I only have some leagues on the API, I'm going to make it static
        * */
        finalLeague.add(new League(R.drawable.laliga_v_600x600, "LigaEspañola"));
        finalLeague.add(new League(R.drawable.mx_logo, "LigaMx"));
        finalLeague.add(new League(R.drawable.liga_francesa, "Ligue1"));
        finalLeague.add(new League(R.drawable.endervise, "Eredivisie"));
        finalLeague.add(new League(R.drawable.bundesliga_logo, "bundesliga"));
        finalLeague.add(new League(R.drawable.liguea, "serie-a"));
        finalLeague.add(new League(R.drawable.premier, "premier-league"));

        LeagueAdapter leagueAdapter = new LeagueAdapter(finalLeague);
        // I set up the adapter to run everything
        recyclerView.setAdapter(leagueAdapter);
        checkForPermission();
    }

    private void setUpToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.text_bar_toolbar);
    }

    private void checkForPermission(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Log.e(TAG,"We hace permission");
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISION_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISION_REQUEST: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Log.e(TAG, "We ask now we got permission");
                else{
                    Log.e(TAG, "I never got permision");
                }
            }
        }
    }
}
