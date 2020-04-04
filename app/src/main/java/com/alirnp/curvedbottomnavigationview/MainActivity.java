package com.alirnp.curvedbottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurvedBottomNavigationView mView = findViewById(R.id.customBottomBar);
      //  mView.inflateMenu(R.menu.bottom_menu);
        mView.setSelectedItemId(R.id.action_schedules);
        //getting bottom navigation view and attaching the listener
        mView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorites:
                        break;
                    case R.id.action_schedules:
                        break;
                    case R.id.action_music:
                        break;
                }
                return true;

            }
        });
    }

}
