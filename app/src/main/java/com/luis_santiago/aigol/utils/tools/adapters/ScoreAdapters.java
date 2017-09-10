package com.luis_santiago.aigol.utils.tools.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.*;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.data.news.score.ScoreTeam;
import com.luis_santiago.aigol.utils.tools.utils.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


/**
 * Created by legendarywicho on 8/3/17.
 */

public class ScoreAdapters extends RecyclerView.Adapter <ScoreAdapters.HoldViewer>{
    private List <ScoreTeam> mScoreArraList = new ArrayList<>();


    public ScoreAdapters(List<ScoreTeam> fl){
        this.mScoreArraList = fl;
    }

    public void setTableTeams(List <ScoreTeam> team){
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
        ScoreTeam scoreTeam = mScoreArraList.get(position);
        String url_home = scoreTeam.getTeam_home_logo();
        String url_away = scoreTeam.getTeamAwayLogo();
        /*
         * This is for downloading and saving the image on a local file
         */
        Utils.DownloadImage(holder.homeTeam, url_home);
        Utils.DownloadImage(holder.awayTeam, url_away);

        holder.nameHomeTeam.setText(scoreTeam.getTeam_home());
        holder.finalScore.setText(scoreTeam.getFinalScore());
        holder.nameAwayTeam.setText(scoreTeam.getTeamAway());
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
