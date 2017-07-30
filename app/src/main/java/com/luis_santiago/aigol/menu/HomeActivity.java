package com.luis_santiago.aigol.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.luis_santiago.aigol.R;

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

    }


    private void setUpNavegation(){
        mBottomNavigationViewEx.enableAnimation(false);
        mBottomNavigationViewEx.enableItemShiftingMode(false);
        mBottomNavigationViewEx.enableShiftingMode(false);
        mBottomNavigationViewEx.setTextVisibility(true);
    }
}
