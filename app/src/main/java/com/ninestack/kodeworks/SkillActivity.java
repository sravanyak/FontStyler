package com.ninestack.kodeworks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.eralp.circleprogressview.CircleProgressView;
import com.eralp.circleprogressview.ProgressAnimationListener;

public class SkillActivity extends AppCompatActivity {

    CircleProgressView mCircleProgressView,mCircleProgressView1,mCircleProgressView2,mCircleProgressView3,mCircleProgressView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mCircleProgressView  = (CircleProgressView) findViewById(R.id.circle_progress_view);
        mCircleProgressView1 = (CircleProgressView) findViewById(R.id.circle_progress_view1);
        mCircleProgressView2 = (CircleProgressView) findViewById(R.id.circle_progress_view2);
        mCircleProgressView3 = (CircleProgressView) findViewById(R.id.circle_progress_view3);
        mCircleProgressView4 = (CircleProgressView) findViewById(R.id.circle_progress_view4);

        mCircleProgressView1.setTextEnabled(true);
        mCircleProgressView1.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleProgressView1.setStartAngle(45);
        mCircleProgressView1.setProgressWithAnimation(80, 2000);

        mCircleProgressView2.setTextEnabled(true);
        mCircleProgressView2.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleProgressView2.setStartAngle(35);
        mCircleProgressView2.setProgressWithAnimation(85, 2000);

        mCircleProgressView3.setTextEnabled(true);
        mCircleProgressView3.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleProgressView3.setStartAngle(20);
        mCircleProgressView3.setProgressWithAnimation(90, 2000);

        mCircleProgressView.setTextEnabled(true);
        mCircleProgressView.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleProgressView.setStartAngle(10);
        mCircleProgressView.setProgressWithAnimation(95, 2000);

        mCircleProgressView4.setTextEnabled(true);
        mCircleProgressView4.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleProgressView4.setStartAngle(1);
        mCircleProgressView4.setProgressWithAnimation(98, 2000);

        mCircleProgressView.addAnimationListener(new ProgressAnimationListener() {
            @Override
            public void onValueChanged(float value) {

            }

            @Override
            public void onAnimationEnd() {
              //  Toast.makeText(SkillActivity.this, "Animation of CircleProgressView done", Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
