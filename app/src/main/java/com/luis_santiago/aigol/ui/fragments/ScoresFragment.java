package com.luis_santiago.aigol.ui.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
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
import com.luis_santiago.aigol.utils.tools.data.news.score.State;
import com.luis_santiago.aigol.utils.tools.utils.Utils;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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
    private String TAG = ScoresFragment.class.getSimpleName();


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
        mScoreAdapters = new ScoreAdapters(mTableTeamArrayList, getContext(),HomeActivity.leagueName);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        Log.e(TAG, "Estoy en la liga putos" + HomeActivity.leagueName);
        DatabaseReference scores = mDatabase.child("Scores").child(HomeActivity.leagueName);
        scores.keepSynced(true);
        scores.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mTableTeamArrayList.clear();
                mScoreAdapters.notifyDataSetChanged();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Log.e(TAG, "THE DATA OF SNAPSHOT "+ snapshot.getValue());
                    String key= snapshot.getKey();
                    String dates = (String) snapshot.child("date").getValue();
                    String roundSlug = (String) snapshot.child("slugRound").getValue();
                    String finalScore = (String) snapshot.child("finalScore").getValue();
                    String teamAway = (String) snapshot.child("teamAway").getValue();
                    String teamAwayLogo = (String)snapshot.child("teamAwayLogo").getValue();
                    String teamHome = (String)snapshot.child("team_home").getValue();
                    String team_home_logo = (String) snapshot.child("team_home_logo").getValue();

                    State state;
                    try {
                        state = new State(
                                (boolean) snapshot.child("state").child("hasStarted").getValue(),
                                (boolean) snapshot.child("state").child("done").getValue()
                        );
                        Log.e(TAG, "I GOT THE RECENT DATA");
                    }
                    catch (NullPointerException e){
                        //If i dont recive any data, it's going to be false by default
                        Log.e(TAG, "I got an error uploading ");
                        state = new State(false, false);
                    }

                    ScoreTeam scoreTeam = new ScoreTeam(
                            dates,
                            state,
                            key,
                            roundSlug,
                            finalScore,
                            teamAway,
                            teamAwayLogo,
                            teamHome,
                            team_home_logo);
                    mTableTeamArrayList.add(scoreTeam);
                }
                mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
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
