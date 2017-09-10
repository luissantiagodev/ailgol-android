package com.luis_santiago.aigol.ui.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import java.util.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.ui.HomeActivity;
import com.luis_santiago.aigol.utils.tools.adapters.ScoreAdapters;
import com.luis_santiago.aigol.utils.tools.data.news.score.ScoreTeam;
import com.luis_santiago.aigol.utils.tools.utils.Utils;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    // This for getting our results from the observable
    private LinearLayoutManager mLayoutManager;
    //RecycleView UI
    private RecyclerView mRecyclerView;
    //Builder for the dialog incase there is no internet
    private ArrayList<ScoreTeam> mTableTeamArrayList;
    // Setting the adapter
    private ScoreAdapters mScoreAdapters;
    private LinearLayout mLinearLayout;
    // This String is for knowing the legue to request
    private DatabaseReference mDatabase;


    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        init(view);
        mTableTeamArrayList = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DatabaseReference scores = mDatabase.child("Scores").child(HomeActivity.leagueName).child("matches");
        scores.keepSynced(true);
        scores.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Log.e(TAG, "THE DATA IS "+ snapshot.getValue());
                    String roundSlug = (String) snapshot.child("round_slug").getValue();
                    String finalScore = (String) snapshot.child("final_score").getValue();
                    String teamAway = (String) snapshot.child("team_away").getValue();
                    String teamAwayLogo = (String)snapshot.child("team_away_logo").getValue();
                    String teamHome = (String)snapshot.child("team_home").getValue();
                    String team_home_logo = (String) snapshot.child("team_home_logo").getValue();
                    ScoreTeam scoreTeam = new ScoreTeam(
                            roundSlug,
                            finalScore,
                            teamAway,
                            teamAwayLogo,
                            teamHome,
                            team_home_logo);
                    mTableTeamArrayList.add(scoreTeam);
                }
                mScoreAdapters = new ScoreAdapters(mTableTeamArrayList);
                mRecyclerView.setAdapter(mScoreAdapters);
                mLinearLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "There was an error");
            }
        });

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        if(Utils.checkForInternetConection(getContext())){
            Log.e(TAG, "we have internet");
        }
        else{
            Utils.throwDialogue(getContext());
            Log.e(TAG, "we don't have internet");
        }
    }


    private void init(View v){
        mLinearLayout = (LinearLayout) v.findViewById(R.id.progress_bar_layout_score);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycle_view_scores);
    }
}
