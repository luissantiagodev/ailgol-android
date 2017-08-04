package com.luis_santiago.aigol.utils.tools.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.*;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.LatestRoundSlug;
import com.luis_santiago.aigol.SoccerApi.result.FinalScoreResult;
import com.luis_santiago.aigol.utils.tools.data.latest.score.Data;
import com.luis_santiago.aigol.utils.tools.data.latest.score.Match;
import com.luis_santiago.aigol.utils.tools.data.table.score.Standing;


/**
 * Created by legendarywicho on 8/3/17.
 */

public class ScoreAdapters extends RecyclerView.Adapter <ScoreAdapters.HoldViewer>{
    private List <Match> mScoreArraList = new ArrayList<>();


    public ScoreAdapters(List<Match> fl){
        this.mScoreArraList = fl;
    }

    public void setTableTeams(List <Match> team){
        if (team == null){
            return;
        }
        mScoreArraList.clear();
        mScoreArraList.addAll(team);
        notifyDataSetChanged();
    }

    @Override
    public ScoreAdapters.HoldViewer onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scores_list_item_cardview,parent,false);

        return new HoldViewer(view);
    }

    @Override
    public void onBindViewHolder(HoldViewer holder, int position) {

        Match finalScoreResult = mScoreArraList.get(position);

        holder.nameAwayTeam
                .setText(finalScoreResult
                        .getAway()
                        .getTeam());

        holder.nameHomeTeam
                .setText(finalScoreResult
                        .getHome()
                        .getTeam());

        String result = finalScoreResult.getMatchResult();
            if(result.isEmpty() || equals("")){
                result = "0-0";
            }
        holder.finalScore
                .setText(result);

        holder.slugRound
                .setText(Integer.
                        toString(LatestRoundSlug.getInstance()));
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
