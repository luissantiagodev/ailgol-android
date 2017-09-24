package com.luis_santiago.aigol.utils.tools.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.*;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.GlideApp;
import com.luis_santiago.aigol.utils.tools.data.news.score.ScoreTeam;
import com.luis_santiago.aigol.utils.tools.data.news.score.State;
import com.luis_santiago.aigol.utils.tools.utils.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


/**
 * Created by legendarywicho on 8/3/17.
 */

public class ScoreAdapters extends RecyclerView.Adapter <ScoreAdapters.HoldViewer>{
    private List <ScoreTeam> mScoreArraList = new ArrayList<>();
    private String TAG = ScoreAdapters.class.getSimpleName();
    private Context mContext;
    private String league;

    public ScoreAdapters(List<ScoreTeam> fl, Context context, String league){
        this.mScoreArraList = fl;
        this.mContext = context;
        this.league = league;
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

        final ScoreTeam scoreTeam = mScoreArraList.get(position);
        final State state = new State(
                scoreTeam.getState().getHasStarted(),
                scoreTeam.getState().isDone()
        );

        if(state.getHasStarted()){
            holder.state.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle));
            holder.state.setText("LIVE");
        }
        else if(state.isDone()){
            holder.state.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle_green));
            holder.state.setText("'90");
        }
        else if(!state.isDone() && !state.getHasStarted()){
            holder.state.setVisibility(View.INVISIBLE);
        }

        String url_home = scoreTeam.getTeam_home_logo();
        String url_away = scoreTeam.getTeamAwayLogo();
        /*
         * This is for downloading and saving the image on a local file
         */

        GlideApp
                .with(mContext)
                .load(url_home)
                .override(200,200)
                .into(holder.homeTeam);
        GlideApp
                .with(mContext)
                .load(url_away)
                .override(200,200)
                .into(holder.awayTeam);


         /*We get the score in this format 1-1*/
        String finalScore = scoreTeam.getFinalScore();
        Log.e(TAG, "This is the final score"+ finalScore);
        // we split it
        String scores[] = finalScore.split("-");

        holder.date.setText(scoreTeam.getDate());

        //Now we set the text from the split
        holder.scoreLocal.setText(scores[0]);
        holder.scoreVisitor.setText(scores[1]);
        Log.e(TAG, "THE FIRST SCORE IS "+ scores[0]);
        Log.e(TAG, "THE SECOND SCORE IS "+ scores[1]);

        holder.slugRound.setText(scoreTeam.getSlugRound());
        holder.nameHomeTeam.setText(scoreTeam.getTeam_home());
        holder.nameAwayTeam.setText(scoreTeam.getTeamAway());

    }

    @Override
    public int getItemCount() {
        return mScoreArraList.size();
    }

    public class HoldViewer extends RecyclerView.ViewHolder{

        private TextView date;
        private TextView slugRound;
        private ImageView homeTeam;
        private TextView nameHomeTeam;
        private ImageView awayTeam;
        private TextView nameAwayTeam;
        private TextView scoreLocal;
        private TextView scoreVisitor;
        private TextView state;

        public HoldViewer(View v) {
            super(v);
            slugRound = (TextView) v.findViewById(R.id.slug_round);
            homeTeam = (ImageView) v.findViewById(R.id.homeLogo);
            nameHomeTeam = (TextView) v.findViewById(R.id.home_team);
            awayTeam =(ImageView) v.findViewById(R.id.awayLogo);
            nameAwayTeam = (TextView) v.findViewById(R.id.team_away);
            scoreLocal = (TextView) v.findViewById(R.id.score_local);
            scoreVisitor = (TextView) v.findViewById(R.id.score_visitor);
            date = (TextView) v.findViewById(R.id.date);
            state = (TextView) v.findViewById(R.id.state_drawable);
        }

    }
}
