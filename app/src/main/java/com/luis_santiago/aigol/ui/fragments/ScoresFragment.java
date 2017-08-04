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
import android.widget.Toast;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.AilGolClient;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.LatestRoundSlug;
import com.luis_santiago.aigol.SoccerApi.result.FinalScoreResult;
import com.luis_santiago.aigol.ui.HomeActivity;
import com.luis_santiago.aigol.utils.tools.adapters.ScoreAdapters;
import com.luis_santiago.aigol.utils.tools.data.latest.score.Data;
import com.luis_santiago.aigol.utils.tools.data.latest.score.Match;
import com.luis_santiago.aigol.utils.tools.data.table.score.Standing;

import net.danlew.android.joda.JodaTimeAndroid;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    // This for getting our results from the observable
    private Subscription mSubscription;
    private RecyclerView.LayoutManager mLayoutManager;
    //RecycleView UI
    private RecyclerView mRecyclerView;
    //Builder for the dialog incase there is no internet
    private AlertDialog.Builder mBuilder;
    private CardView cardView;
    private ArrayList<Match> mTableTeamArrayList;
    // Setting the adapter
    private ScoreAdapters mScoreAdapters;
    private LinearLayout mLinearLayout;


    public ScoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        // Initializing the time Library
        JodaTimeAndroid.init(getContext());

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view_table_fragment);
        cardView = (CardView) view.findViewById(R.id.cardview_score);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.progress_bar_layout_score);

        // setting the layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTableTeamArrayList = new ArrayList<>();

        mScoreAdapters = new ScoreAdapters(mTableTeamArrayList);

        mRecyclerView.setAdapter(mScoreAdapters);

        return view;
    }


    private void getLatestScores (){
        mSubscription = AilGolClient.getInstance()
                // We get the Last round from a singleton for the current date
                .getLatestResults(Integer.toString(LatestRoundSlug.getInstance()),HomeActivity.leagueName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FinalScoreResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ScoresFragment", "We have an error"+e);
                    }

                    @Override
                    public void onNext(FinalScoreResult finalScoreResult) {
                        Log.e("ScoresFragment", "We are having data");
                        mLinearLayout.setVisibility(View.GONE);
                       mScoreAdapters.setTableTeams(finalScoreResult.getData().getMatches());
                    }
                });
    }

    private void throwUpDialogue(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            mBuilder = new AlertDialog.Builder(getContext());
        }

        mBuilder.setTitle("¡Chicharito la fallo!")
                .setMessage("There is no internet connection")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                });
        mBuilder.show();
    }

    private Boolean weHaveInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(weHaveInternet()){
            Log.e(TAG, "we have internet");
            getLatestScores();
        }
        else{
            throwUpDialogue();
            Log.e(TAG, "we don't have internet");
        }
    }
}
