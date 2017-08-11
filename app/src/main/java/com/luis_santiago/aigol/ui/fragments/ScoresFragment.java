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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.ui.HomeActivity;
import com.luis_santiago.aigol.utils.tools.adapters.ScoreAdapters;
import com.luis_santiago.aigol.utils.tools.utils.Utils;

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
    private CardView cardView;
    private ArrayList<String> mTableTeamArrayList;
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
}
