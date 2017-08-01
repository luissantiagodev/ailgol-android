package com.luis_santiago.aigol.menu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.adapters.TableAdapter;
import com.luis_santiago.aigol.utils.tools.pojos.TableTeam;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;
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
        mTableTeamArrayList.add(new TableTeam(2, R.drawable.liguea,23,25,23,23,"Barcelona"));
        mTableTeamArrayList.add(new TableTeam(2, R.drawable.ic_goal_field,23,25,23,23,"Chivas"));
        mTableTeamArrayList.add(new TableTeam(2, R.drawable.premier,23,25,23,23,"Chivas"));
        mTableTeamArrayList.add(new TableTeam(3, R.drawable.premier,23,25,23,23,"Chivas"));

        mTableAdapter =  new TableAdapter(mTableTeamArrayList);
        mRecyclerView.setAdapter(mTableAdapter);
        return view;
    }
}
