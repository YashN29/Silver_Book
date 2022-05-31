package com.example.studypartner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Semester_Dashboard extends Fragment {


    RecyclerView recyclerView;
    List<MyModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_semester__dashboard , container , false);

       recyclerView = v.findViewById(R.id.recycler);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       recyclerView.setAdapter(new MyAdapter(getContext(),initdata()));

        return v;
    }

    private List<MyModel> initdata() {

        ArrayList<MyModel> itemlist = new ArrayList<>();
        itemlist.add(new MyModel(R.drawable.book,"SEM 1"));
        itemlist.add(new MyModel(R.drawable.book,"SEM 2"));
        itemlist.add(new MyModel(R.drawable.book,"SEM 3"));
        itemlist.add(new MyModel(R.drawable.book,"SEM 4"));
        itemlist.add(new MyModel(R.drawable.book,"SEM 5"));


        return itemlist;
    }

}