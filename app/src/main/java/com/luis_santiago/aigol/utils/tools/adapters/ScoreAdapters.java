package com.luis_santiago.aigol.utils.tools.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis_santiago.aigol.R;


/**
 * Created by legendarywicho on 8/3/17.
 */

public class ScoreAdapters extends RecyclerView.Adapter <ScoreAdapters.HoldViewer>{
    private ArrayList <CardScore> mScoreArraList = new ArrayList<>();

    @Override
    public ScoreAdapters.HoldViewer onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scores_list_item_cardview,parent,false);

        return new HoldViewer(view);
    }

    @Override
    public void onBindViewHolder(HoldViewer holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mScoreArraList.size();
    }



    public class HoldViewer extends RecyclerView.ViewHolder{

        private TextView slugRound;
        private ImageView homeTeam;
        private TextView nameHomeTeam;
        private TextView finalScore;
        private ImageView awayTeam;
        private TextView nameAwayTeam;

        public HoldViewer(View v) {
            super(v);
            slugRound = (TextView) v.findViewById(R.id.slug_round);
            homeTeam = (ImageView) v.findViewById(R.id.homeLogo);
            nameHomeTeam = (TextView) v.findViewById(R.id.home_team);
            finalScore = (TextView) v.findViewById(R.id.score);
            awayTeam = (ImageView) v.findViewById(R.id.awayLogo);
            nameAwayTeam = (TextView) v.findViewById(R.id.team_away);
        }

    }
}
