package com.luis_santiago.aigol.ui.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import java.util.*;
import android.view.View;
import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.ui.HomeActivity;
import com.luis_santiago.aigol.utils.tools.adapters.TableAdapter;
import com.luis_santiago.aigol.utils.tools.data.news.score.TableTeam;
import com.luis_santiago.aigol.utils.tools.utils.Utils;

import org.w3c.dom.Text;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;
import static com.luis_santiago.aigol.utils.tools.utils.Utils.generateTableTeam;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    // This is for debugging
    private String TAG = TablesFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    // Progress bar, when we have conection it's remove
    private LinearLayout mLinearLayout;
    // This thing too
    private ProgressBar isThereInternetConnection;
    //this is for fetching data
    private SwipeRefreshLayout swipeRefreshLayout;
    // The list we are going to display
    ArrayList<TableTeam> mTableTeamArrayList;
    private TableAdapter mTableAdapter;
    //Textview from appbar
    private TextView textAppBar;
    private boolean haveUpdated = false;

    public TablesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tables, container, false);
        init(view);
        // Setting the color
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        //
        mRecyclerView.setLayoutManager(mLayoutManager);
        // Creating our list
        mTableTeamArrayList = new ArrayList<>();
        //Setting our adapter
        mTableAdapter = new TableAdapter(mTableTeamArrayList, getContext());
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(mTableAdapter);
        // Creating an instance of the database
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        //Finding the correct reference to read our data
        DatabaseReference standing = mDatabase.child("Standings").child(HomeActivity.leagueName);
        standing.keepSynced(true);
        // To read our data we need to add the value Listener
        Query query = standing.orderByChild("position");
        query.addListenerForSingleValueEvent(valueEventListener);

        standing.addValueEventListener(new ValueEventListener() {
            ArrayList<TableTeam> refreshList = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    TableTeam tableTeam = generateTableTeam(snapshot);
                    refreshList.add(tableTeam);
                }
                mTableTeamArrayList = refreshList;
                haveUpdated = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        ArrayList<TableTeam> finalList = new ArrayList<>();
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                TableTeam tableTeam = Utils.generateTableTeam(snapshot);
                finalList.add(tableTeam);
            }
            mTableAdapter.setTableTeams(finalList);
            mLinearLayout.setVisibility(View.GONE);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    };

    @Override
    public void onResume() {
      super.onResume();
        if(Utils.checkForInternetConection(getContext())){
            Log.e(TAG, "we have internet");
        }
        else{
            Utils.throwDialogue(getContext());
            Log.e(TAG, "we don't have internet");
            isThereInternetConnection.setVisibility(View.GONE);
        }
    }



    private void init(View view){
        //Casting all the UI components
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_table_fragment);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.progress_bar_layout);
        isThereInternetConnection = (ProgressBar) view.findViewById(R.id.progress_bar_interner);
    }
}