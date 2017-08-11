package com.luis_santiago.aigol.ui.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.*;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.SoccerApi.data.Singletons.AigolClientNews;
import com.luis_santiago.aigol.SoccerApi.result.NewsFinalResult;
import com.luis_santiago.aigol.utils.tools.adapters.NewsAdapter;
import com.luis_santiago.aigol.utils.tools.data.news.score.Article;

import rx.*;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private Subscription mSubscription;
    private RecyclerView.LayoutManager mLayoutManager;
    //RecycleView UI
    private RecyclerView mRecyclerView;
    //Builder for the dialog incase there is no internet
    private AlertDialog.Builder mBuilder;
    private ArrayList <Article> mTableTeamArrayList;
    // Setting the adapter
    private NewsAdapter mNewsAdapter;
    private LinearLayout mLinearLayout;


    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view_news);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.progress_bar_layout_news);

        // setting the layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTableTeamArrayList = new ArrayList<>();

        mNewsAdapter = new NewsAdapter (mTableTeamArrayList);

        mRecyclerView.setAdapter(mNewsAdapter);

        return view;
    }

    private void setUpRequest(){
        mSubscription = AigolClientNews.getInstance()
                .getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsFinalResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsFinalResult newsFinalResult) {
                        mLinearLayout.setVisibility(View.GONE);
                        mNewsAdapter.setNewList(newsFinalResult.getArticles());
                    }
                });
    }
    private void throwUpDialogue(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            mBuilder = new AlertDialog.Builder(getContext());
        }

        mBuilder.setTitle("¡Chicharito la fallo!")
                .setMessage("There is no internet connection")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                });
        mBuilder.show();
    }

    private Boolean weHaveInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(weHaveInternet()){
            Log.e(TAG, "we have internet");
            setUpRequest();
        }
        else{
            throwUpDialogue();
            Log.e(TAG, "we don't have internet");
        }
    }
}
