package com.luis_santiago.aigol.utils.tools.adapters;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import com.bumptech.glide.Glide;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.luis_santiago.aigol.BuildConfig;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.GlideApp;
import com.luis_santiago.aigol.utils.tools.data.news.score.TableTeam;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import static android.R.attr.path;
import static java.lang.System.load;

/**
 * Created by legendarywicho on 7/31/17.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableAdapterHolder>{

    private List <TableTeam> mTableTeams = new ArrayList<>();
    private Context mContext;


    public TableAdapter(List <TableTeam> team, Context c){
        this.mTableTeams = team;
        this.mContext = c;
    }

    public void setTableTeams(List <TableTeam> team){
        if (team == null){
            return;
        }
        mTableTeams.clear();
        mTableTeams.addAll(team);
        notifyDataSetChanged();
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

        holder.position.setText(tableTeam.getPosition());
        final String url = tableTeam.getLogo();


        GlideApp
                .with(mContext)
                .load(url)
                .centerCrop()
                .override(200,200)
                .into(holder.imageView);

        holder.teamName.setText(tableTeam.getName());
        holder.matchesPlayed.setText(tableTeam.getMp());
        holder.goalFor.setText(tableTeam.getGf());
        holder.goalAfter.setText(tableTeam.getGa());
        holder.goalDiference.setText(tableTeam.getGd());
        holder.points.setText(tableTeam.getPts());
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
         TextView goalFor;
         TextView goalAfter;
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
             goalFor = (TextView) v.findViewById(R.id.goal_for);
             goalAfter = (TextView) v.findViewById(R.id.goal_after);
             goalDiference = (TextView) v.findViewById(R.id.goal_difference);
             points = (TextView) v.findViewById(R.id.points);
         }
     }
}
