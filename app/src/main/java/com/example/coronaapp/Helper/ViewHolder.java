package com.example.coronaapp.Helper;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.coronaapp.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder{

    View mView;
    public ViewHolder(View itemView){
        super(itemView);

        mView=itemView;
    }

    public void setDetails(Context context,String title,String description ,String image){

        TextView mTitleView=mView.findViewById(R.id.rTitleTv);
        TextView mDecription=mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageView=mView.findViewById(R.id.rImageView);
        mTitleView.setText(title);
        mDecription.setText(description);
        Picasso.get().load(image).fit().centerCrop().into(mImageView);
    }
}
