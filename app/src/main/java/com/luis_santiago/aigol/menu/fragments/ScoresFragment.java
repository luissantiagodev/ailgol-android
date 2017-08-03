package com.luis_santiago.aigol.menu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.LatestRoundSlug;
import com.luis_santiago.aigol.menu.HomeActivity;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;
import com.luis_santiago.aigol.utils.tools.pojos.DateScoreLegue;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        // Iniciatilizing the time Library
        JodaTimeAndroid.init(getContext());
        //getting a static method from a Singleton were we just receive a int

        int carl = LatestRoundSlug.getInstance();

        Toast.makeText(getContext(), "El numero es"+Integer.toString(carl), Toast.LENGTH_SHORT).show();

        return view;
    }

}
