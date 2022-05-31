package com.example.studypartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Doubts_Adapter extends RecyclerView.Adapter<Doubts_Adapter.Myclass> {

    Context context;
    List<Doubts_Model> modelList;

    public Doubts_Adapter(Context context, List<Doubts_Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Doubts_Adapter.Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doubt_row_layout,parent,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Doubts_Adapter.Myclass holder, int position) {

        holder.doubts.setText(modelList.get(position).getDoubts());
        holder.img_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Successfully Submitted!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.card1.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animation));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class Myclass extends RecyclerView.ViewHolder {

        TextView doubts;
        CardView card1;
        ImageView img_send;

        public Myclass(@NonNull View itemView) {
            super(itemView);

            doubts = itemView.findViewById(R.id.doubts);
            card1 = itemView.findViewById(R.id.card1);
            img_send = itemView.findViewById(R.id.img_send);
        }
    }
}
