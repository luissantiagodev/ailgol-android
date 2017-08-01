package com.luis_santiago.aigol.menu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.AilGolClient;
import com.luis_santiago.aigol.SoccerApi.ApiSoccerRequest;
import com.luis_santiago.aigol.menu.HomeActivity;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;
import com.luis_santiago.aigol.utils.tools.adapters.TableAdapter;
import com.luis_santiago.aigol.utils.tools.pojos.TableTeam;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    // This is for debugging
    private String TAG = TablesFragment.class.getSimpleName();
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;
    // This is for getting all the data from the Observer
    Subscription mSubscription;
    // This is the bundle Object we Recieve from the Main Activity league selection


    ArrayList<TableTeam> mTableTeamArrayList;

    public TablesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tables, container, false);
        // Finding the second recycle view
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recycle_view_table_fragment);
        //Setting the reference on to the main activity
        mLayoutManager = new LinearLayoutManager(view.getContext());
        // Setting the Layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);


        /**
         * This is just for testing, delete after request
         */
        mTableTeamArrayList= new ArrayList<>();

        mTableTeamArrayList.add(new TableTeam(1, R.drawable.premier,23,25,23,23,"Madrid"));

        mTableAdapter =  new TableAdapter(mTableTeamArrayList);
        mRecyclerView.setAdapter(mTableAdapter);

        getLeagueTeams();

        return view;
    }

    private void getLeagueTeams(){
        mSubscription = AilGolClient.getInstance()
                .getTeamLeagues(HomeActivity.leagueName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TableTeam>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "I'm done with the data!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "There was an error with the data!"+ e);
                    }

                    @Override
                    public void onNext(TableTeam tableTeams) {
                        Log.e("TAG", "I got the data"+tableTeams);
                        Log.e("TAG", "ESTOY EN LA LIGA "+ HomeActivity.leagueName);
                       mTableTeamArrayList.add(tableTeams);
                    }
                });
    }
}