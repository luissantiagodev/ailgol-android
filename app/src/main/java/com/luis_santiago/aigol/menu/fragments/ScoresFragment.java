package com.luis_santiago.aigol.menu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.menu.HomeActivity;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {


    String legueName ="";

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

}
