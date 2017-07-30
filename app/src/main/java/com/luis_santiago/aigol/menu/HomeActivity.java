package com.luis_santiago.aigol.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.luis_santiago.aigol.MainActivity;
import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.menu.fragments.NewsFragment;
import com.luis_santiago.aigol.menu.fragments.ScoresFragment;
import com.luis_santiago.aigol.menu.fragments.TablesFragment;

import static android.R.attr.id;

public class HomeActivity extends AppCompatActivity {


    //Bottom Nav view
    BottomNavigationViewEx mBottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_bar);
        // Enabling text and icon view
        setUpNavegation();

        mBottomNavigationViewEx.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        /*
        * If the user hasn't clicked a icon, then we will set the default fragment
        * */
        settingFragment(new ScoresFragment());
        setUpGreenIcon(1);
    }


    private void setUpNavegation(){
        mBottomNavigationViewEx.enableAnimation(false);
        mBottomNavigationViewEx.enableItemShiftingMode(false);
        mBottomNavigationViewEx.enableShiftingMode(false);
        mBottomNavigationViewEx.setTextVisibility(true);

    }


    private void setUpGreenIcon(int a){
        mBottomNavigationViewEx.setIconTintList(a, getResources()
                .getColorStateList(R.color.progress_color));
    }

    private void setUpGrayIcon(int a){
        mBottomNavigationViewEx.setIconTintList(a, getResources()
                .getColorStateList(R.color.colorPrimaryDark));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            final Menu menu = mBottomNavigationViewEx.getMenu();
            int checkNumber = mBottomNavigationViewEx.getMenuItemPosition(item);


            switch (item.getItemId()){

                case R.id.ic_tables:{
                    settingFragment(new TablesFragment());
                    setUpGreenIcon(0);
                    setUpGrayIcon(1);
                    setUpGrayIcon(2);
                    break;
                }

                case R.id.ic_scores:{
                    settingFragment(new ScoresFragment());
                    setUpGreenIcon(1);
                    setUpGrayIcon(0);
                    setUpGrayIcon(2);
                    break;
                }

                case R.id.ic_news:{
                    settingFragment(new NewsFragment());
                    setUpGreenIcon(2);
                    setUpGrayIcon(0);
                    setUpGrayIcon(1);
                    break;
                }

            }

            MenuItem menuItem = menu.getItem(checkNumber);
            menuItem.setChecked(true);
            return false;
        }
    };


    private void settingFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_activity, fragment)
                .setTransition(FragmentTransaction.TRANSIT_EXIT_MASK)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }
}
