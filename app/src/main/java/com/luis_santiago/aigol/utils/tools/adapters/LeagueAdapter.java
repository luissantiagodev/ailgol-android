package com.luis_santiago.aigol.utils.tools.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.*;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.menu.HomeActivity;
import com.luis_santiago.aigol.utils.tools.pojos.LeagueTeam;

/**
 * Created by legendarywicho on 7/28/17.
 */

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.PhotoHolder>{

    private ArrayList <LeagueTeam> mLeagueTeams = new ArrayList<>();

    public LeagueAdapter(ArrayList<LeagueTeam> lg){
        this.mLeagueTeams =lg;
    }

    @Override
    public LeagueAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view,parent,false);

        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeagueAdapter.PhotoHolder holder, final int position) {

        final LeagueTeam leagueTeam = mLeagueTeams.get(position);
        holder.imageView.setImageResource(leagueTeam.getImageDrawable());


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Legue adapter", "Im touching the:"+ position);
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                // TODO: Send a Bundle object to know which league request we are going to make
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mLeagueTeams.size();
    }

    static class PhotoHolder extends RecyclerView.ViewHolder implements ViewGroup.OnClickListener{

        private ImageView imageView;

        public PhotoHolder(View itemView) {
            super(itemView);

            imageView =  (ImageView) itemView.findViewById(R.id.image_logo_league);
        }

        @Override
        public void onClick(View v) {
            Log.e("Adapter", "I'm clicked");
        }
    }

}
