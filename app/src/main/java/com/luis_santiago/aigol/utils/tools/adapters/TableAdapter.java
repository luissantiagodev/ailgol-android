package com.luis_santiago.aigol.utils.tools.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.pojos.TableTeam;

/**
 * Created by legendarywicho on 7/31/17.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableAdapterHolder>{

    private ArrayList <TableTeam> mTableTeams = new ArrayList<>();


    public TableAdapter(ArrayList <TableTeam> team){
        this.mTableTeams = team;
    }

    @Override
    public TableAdapter.TableAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_tables,parent,false);

        return new TableAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(TableAdapterHolder holder, int position) {
        final TableTeam tableTeam = mTableTeams.get(position);

        // Setting up the hole reference on my views
        holder.position.setText(Integer.toString(tableTeam.getPosition()));
        holder.imageView.setImageResource(tableTeam.getLogo());
        holder.teamName.setText(tableTeam.getTeamName());
        holder.matchesPlayed.setText(Integer.toString(tableTeam.getMp()));
        holder.scores.setText(Integer.toString(tableTeam.getGf()));
        holder.goalDiference.setText(Integer.toString(tableTeam.getGa()));
        holder.points.setText(Integer.toString(tableTeam.getPts()));
    }

    @Override
    public int getItemCount() {
        return mTableTeams.size();
    }


     static class TableAdapterHolder extends RecyclerView.ViewHolder {
         TextView position;
         ImageView imageView;
         TextView teamName;
         TextView matchesPlayed;
         TextView scores;
         TextView goalDiference;
         TextView points;
         View layout;
         public TableAdapterHolder(View v) {
             super(v);
             layout = v;
             position = (TextView) v.findViewById(R.id.position);
             imageView = (ImageView) v.findViewById(R.id.logo_team);
             teamName = (TextView) v.findViewById(R.id.team);
             matchesPlayed = (TextView) v.findViewById(R.id.matches_played);
             scores = (TextView) v.findViewById(R.id.scores);
             goalDiference = (TextView) v.findViewById(R.id.goal_difference);
             points = (TextView) v.findViewById(R.id.points);
         }
     }
}
