package com.example.coronaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronaapp.Model.ModelAdviceCorona;
import com.example.coronaapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapterA extends RecyclerView.Adapter<RecyclerAdapterA.ViewHolder> {

    private static final String Tag ="Recycler";

    private Context mcontext;
    private ArrayList<ModelAdviceCorona>mmodelAdviceCoronas;

    public RecyclerAdapterA(Context mcontext,ArrayList<ModelAdviceCorona> mmodelAdviceCoronas){
        this.mcontext=mcontext;
        this.mmodelAdviceCoronas=mmodelAdviceCoronas;
    }

    @NonNull
    @Override
    public RecyclerAdapterA.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mmodelAdviceCoronas.get(position).getTitle());
        holder.desc.setText(mmodelAdviceCoronas.get(position).getDescription());
        Picasso.get().load(mmodelAdviceCoronas.get(position).getImage()).fit().centerCrop().into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mmodelAdviceCoronas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


       ImageView imageView;
       TextView title;
       TextView desc;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           imageView=itemView.findViewById(R.id.rImageView);
           title=itemView.findViewById(R.id.rTitleTv);
           desc=itemView.findViewById(R.id.rDescriptionTv);

       }
   }
}
