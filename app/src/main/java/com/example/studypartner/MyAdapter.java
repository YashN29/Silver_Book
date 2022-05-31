package com.example.studypartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyClass>
{
    Context context;
    List<MyModel> iteamList1;

    public MyAdapter(Context context, List<MyModel> iteamList1) {
        this.context = context;
        this.iteamList1 = iteamList1;
    }

    @NonNull
    @Override
    public MyAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout , parent , false);
        return new MyClass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyClass holder, int position)
    {
        MyModel my = iteamList1.get(position);

        holder.imv.setImageResource(my.getImg());
        holder.tv.setText(my.getTitle());

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();

                Sem_1 sem1 = new Sem_1();
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, sem1)
                        .addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return iteamList1.size();
    }

    public class MyClass extends RecyclerView.ViewHolder
    {
        ImageView imv;
        TextView tv;
        public MyClass(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.book);
            tv = itemView.findViewById(R.id.tv_sem1);
        }
    }
}
