package com.luis_santiago.aigol.utils.tools.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.*;
import android.widget.TextView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;
import com.luis_santiago.aigol.utils.tools.data.news.score.Article;
import com.squareup.picasso.Picasso;

import static com.luis_santiago.aigol.R.id.team;

/**
 * Created by legendarywicho on 8/4/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List <Article> mNewsFinalResultList = new ArrayList<>();


    public NewsAdapter(ArrayList <Article> articles){
        this.mNewsFinalResultList = articles;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = mNewsFinalResultList.get(position);

        String url = article.getUrlToImage();
            Picasso.with(holder.foto.getContext()).load(url).into(holder.foto);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
    }

    @Override
    public int getItemCount() {
        return mNewsFinalResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView title;
        private TextView description;
        // All out ui references

        public ViewHolder(View v) {
            super(v);

            foto= (ImageView) v.findViewById(R.id.image_news_main);
            title = (TextView) v.findViewById(R.id.main_title);
            description = (TextView) v.findViewById(R.id.description);
        }
    }
}
