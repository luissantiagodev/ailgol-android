package com.luis_santiago.aigol.utils.tools.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.*;
import android.widget.TextView;
import android.widget.Toast;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;
import com.luis_santiago.aigol.ui.WebActivity;
import com.luis_santiago.aigol.utils.tools.GlideApp;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;
import com.luis_santiago.aigol.utils.tools.data.news.score.Article;
import com.squareup.picasso.Picasso;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import static com.luis_santiago.aigol.R.id.cardview_score;
import static com.luis_santiago.aigol.R.id.team;

/**
 * Created by legendarywicho on 8/4/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List <Article> mNewsFinalResultList = new ArrayList<>();
    private Context mContext;


    public NewsAdapter(ArrayList <Article> articles, Context context){
        this.mNewsFinalResultList = articles;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating the the view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_cardview, parent, false);
        return new ViewHolder(view);
    }

    public void setNewList(List <Article> articles){
        if (articles == null){
            return;
        }
        mNewsFinalResultList.clear();
        mNewsFinalResultList.addAll(articles);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Article article = mNewsFinalResultList.get(position);
        final Bundle bundle = new Bundle();
        String url = article.getUrlToImage();
        GlideApp
                .with(holder.foto.getContext())
                .load(url)
                .into(holder.foto);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.generalCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.generalCardview.getContext(), WebActivity.class);
                bundle.putString(Keys.URL_BASE_NEWS, article.getUrl());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsFinalResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView title;
        private TextView description;
        private CardView generalCardview;
        // All out ui references

        public ViewHolder(View v) {
            super(v);

            foto= (ImageView) v.findViewById(R.id.image_news_main);
            title = (TextView) v.findViewById(R.id.main_title);
            description = (TextView) v.findViewById(R.id.description);
            generalCardview = (CardView) v.findViewById(R.id.cardview_score);
        }
    }
}
