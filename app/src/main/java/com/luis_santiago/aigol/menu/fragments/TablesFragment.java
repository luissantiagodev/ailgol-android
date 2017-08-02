package com.luis_santiago.aigol.menu.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.AilGolClient;
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
    // This is for the progress bar, when we have conection it's remove
    private LinearLayout mLinearLayout;
    // This thing too
    private ProgressBar isThereInternetConnection;
    // This is for getting all the data from the Observer
    Subscription mSubscription;
    //Creating a Dialog if there isn't no internet
    AlertDialog.Builder mBuilder;
    // The list we are going to display
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
        isThereInternetConnection = (ProgressBar) view.findViewById(R.id.progress_bar_interner);

        /**
         * This is just for testing, delete after request
         */
        mTableTeamArrayList= new ArrayList<>();

        mTableAdapter =  new TableAdapter(mTableTeamArrayList);
        mRecyclerView.setAdapter(mTableAdapter);

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
                        Log.e(TAG, ""+e);
                    }
                    @Override
                    public void onNext(FinalResultSoccerTable finalResultSoccerTable) {
                        Log.e(TAG, "Im starting the request");
                        mLinearLayout.setVisibility(View.GONE);
                        mTableAdapter.setTableTeams(finalResultSoccerTable.getData().getStandings());
                    }
                });
    }

    @Override
    public void onResume() {
      super.onResume();
        if(weHaveInternet()){
            Log.e(TAG, "we have internet");
            getLeagueTeams();
        }
        else{
            throwUpDialogue();
            Log.e(TAG, "we don't have internet");
            isThereInternetConnection.setVisibility(View.GONE);
        }
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
                    }
                });
        mBuilder.show();
    }

    private Boolean weHaveInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

}