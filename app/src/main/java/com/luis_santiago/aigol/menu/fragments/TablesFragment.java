package com.luis_santiago.aigol.menu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.AilGolClient;
import com.luis_santiago.aigol.SoccerApi.FinalResultSoccerTable;
import com.luis_santiago.aigol.SoccerApi.data.Standing;
import com.luis_santiago.aigol.menu.HomeActivity;
import com.luis_santiago.aigol.utils.tools.adapters.TableAdapter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    // This is for debugging
    private String TAG = TablesFragment.class.getSimpleName();
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;
    private LinearLayout mLinearLayout;
    // This is for getting all the data from the Observer
    Subscription mSubscription;
    // This is the bundle Object we Recieve from the Main Activity league selection


    ArrayList<Standing> mTableTeamArrayList;

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

        mLinearLayout = (LinearLayout) view.findViewById(R.id.progress_bar_layout);

        /**
         * This is just for testing, delete after request
         */
        mTableTeamArrayList= new ArrayList<>();

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
                .subscribe(new Observer<FinalResultSoccerTable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FinalResultSoccerTable finalResultSoccerTable) {
                        mLinearLayout.setVisibility(View.GONE);
                        mTableAdapter.setTableTeams(finalResultSoccerTable.getData().getStandings());
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}