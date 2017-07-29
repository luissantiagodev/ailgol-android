package com.luis_santiago.aigol.Tools.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.start.lib.LeagueTeam;

/**
 * Created by legendarywicho on 7/28/17.
 */

public class LeagueAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList <LeagueTeam> mLeagueTeams = new ArrayList<>();


    public LeagueAdapter(Activity context, ArrayList <LeagueTeam> ls){
        this.mContext = context;
        this.mLeagueTeams = ls;
    }

    @Override
    public int getCount() {
        return mLeagueTeams.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_view,parent,false);
        }
        LeagueTeam leagueTeam = mLeagueTeams.get(position);

        final ImageView logo = (ImageView)convertView.findViewById(R.id.image_logo_league);

        logo.setImageResource(leagueTeam.getImageDrawable());

        return convertView;
    }
}
