package com.luis_santiago.aigol.ui;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewFragment;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.ui.fragments.NewsFragment;
import com.luis_santiago.aigol.ui.fragments.ScoresFragment;
import com.luis_santiago.aigol.ui.fragments.TablesFragment;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends DrawerActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    private Drawable foto1;
    private Drawable foto2;
    private Drawable foto3;
    private TextView logoWhite;
    private InterstitialAd interstitialAd;
    private AdView mAdview;

    // This Bundle is for receiving data from the main Activity
    Bundle mBundle;
    public static String leagueName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        setTitle("");
        ButterKnife.bind(this);
        logoWhite = (TextView) findViewById(R.id.logo_white);

        mAdview = (AdView) findViewById(R.id.banner);
        //starting to show the banner add
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5461480863776866/3346084113");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("FA73653EA402CC30D55A5140976DA6C4")
                .build();
        mAdview.loadAd(adRequest);
        // Setting up the mBundle object
        mBundle = getIntent().getExtras();
        leagueName = mBundle.getString(Keys.TEAM_NAME);
        Log.e("Main activity", "IM at the "+leagueName);

        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if(leagueName.equals("LigaMx")){
            foto1 = getResources().getDrawable(R.drawable.chivas);
            foto2 = getResources().getDrawable(R.drawable.pumas);
            foto3 = getResources().getDrawable(R.drawable.america);
            logoWhite.setText("LigaMx");
        }
        else if(leagueName.equals("LigaEspañola")){
            foto1 = getResources().getDrawable(R.drawable.madrid);
            foto2 = getResources().getDrawable(R.drawable.messi);
            foto3 = getResources().getDrawable(R.drawable.ronaldo);
            logoWhite.setText("La Liga");
        }
        else if(leagueName.equals("Ligue1")){
            foto1 = getResources().getDrawable(R.drawable.monaco);
            foto2 = getResources().getDrawable(R.drawable.psg);
            foto3 = getResources().getDrawable(R.drawable.lyon);
            logoWhite.setText("La Liga");
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                       return new TablesFragment();
                    case 1:
                        return new ScoresFragment();
                    case 2:
                       return new NewsFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Standings";
                    case 1:
                        return "Matches";
                    case 2:
                        return "News";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorAndDrawable(
                                getResources().getColor(R.color.progress_color),
                                foto1);
                    case 1:
                        return HeaderDesign.fromColorAndDrawable(
                                getResources().getColor(R.color.progress_color),
                                foto2);
                    case 2:
                        return HeaderDesign.fromColorAndDrawable(
                                getResources().getColor(R.color.progress_color),
                                foto3);
                }
                return null;
            }
        });

        mViewPager
                .getViewPager()
                .setOffscreenPageLimit(mViewPager
                .getViewPager()
                .getAdapter()
                .getCount());
        mViewPager
                .getPagerTitleStrip()
                .setViewPager(mViewPager.getViewPager());

    }
    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdview != null) {
            mAdview.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if (mAdview!= null) {
            mAdview.destroy();
        }
        super.onDestroy();
    }
}
