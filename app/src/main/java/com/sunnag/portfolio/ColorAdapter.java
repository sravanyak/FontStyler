package com.sunnag.portfolio;

/**
 * Created by Sanny on 1/23/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunnag.fontstyler.FontStylerView;

import java.util.Random;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private String[] mDataSet;
    private Context mContext;
    private Random mRandom = new Random();

    public ColorAdapter(Context context,String[] DataSet){
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public FontStylerView mTextView;
        ImageView mImageView ;
        public ViewHolder(View v){
            super(v);
            mTextView = (FontStylerView)v.findViewById(R.id.tv);
            mImageView = (ImageView) v.findViewById(R.id.imageView2);
        }
    }

    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.portfolio_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        holder.mTextView.setText(mDataSet[position]);
        // Set a random height for TextView
        holder.mImageView.getLayoutParams().height = getRandomIntInRange(250,75);
        // Set a random color for TextView background
        holder.mTextView.setBackgroundColor(getRandomHSVColor());

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                // Pass data object in the bundle and populate details activity.
                //     intent.putExtra(DetailsActivity.EXTRA_CONTACT, contact);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) mContext,  holder.mImageView, "profile");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mContext.startActivity(intent, options.toBundle());
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return mDataSet.length;
    }

    // Custom method to get a random number between a range
    protected int getRandomIntInRange(int max, int min){
        return mRandom.nextInt((max-min)+min)+min;
    }

    // Custom method to generate random HSV color
    protected int getRandomHSVColor(){
        // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);
        // We make the color depth full
        float saturation = 1.0f;
        // We make a full bright color
        float value = 1.0f;
        // We avoid color transparency
        int alpha = 180;
        // Finally, generate the color
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color
        return color;
    }
}