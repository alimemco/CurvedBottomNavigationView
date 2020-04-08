package com.alirnp.curvedbottomnavigationview;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private float original = 0f;
    private float rotated = 45f;
    private boolean isOriginalMode = true;

    private ImageView mImageView;
    private ConstraintLayout mConstraintLayout;
    private ConstraintLayout mConstraintLayoutRoot;

    private int mColorPrimary;
    private int mColorWhite;

    public static void rotateOvershoot(View view, float rotate) {
        OvershootInterpolator interpolator = new OvershootInterpolator();

        ViewCompat.animate(view).
                rotation(rotate).
                withLayer().
                setDuration(400).
                setInterpolator(interpolator).
                start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurvedBottomNavigationView mView = findViewById(R.id.customBottomBar);
        mImageView = findViewById(R.id.fab);
        mConstraintLayout = findViewById(R.id.lin_id);
        mConstraintLayoutRoot = findViewById(R.id.root);

        mColorPrimary = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
        mColorWhite = ContextCompat.getColor(MainActivity.this, R.color.white);

        mView.setSelectedItemId(R.id.action_favorites);
        mView.getMenu().findItem(R.id.action_schedules).setCheckable(false);
/*
        View beneathView = //the view that beneath blur view
                View blurView= //blur View
*/




        mView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorites:
                        break;
                    case R.id.action_schedules:
                        validateState();
                        break;
                    case R.id.action_music:
                        break;
                }
                return true;

            }
        });


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateState();
            }
        });

        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateState();
            }
        });


    }

    private void validateState() {

        isOriginalMode = !isOriginalMode;

        rotateOvershoot(mImageView, isOriginalMode ? original : rotated);
        ImageViewCompat.setImageTintList(mImageView, ColorStateList.valueOf(isOriginalMode ? mColorPrimary : mColorWhite));
        mConstraintLayout.setBackground(isOriginalMode ? ContextCompat.getDrawable(MainActivity.this, R.drawable.shape_circle) : ContextCompat.getDrawable(MainActivity.this, R.drawable.shape_circle_opend));

    }
}
