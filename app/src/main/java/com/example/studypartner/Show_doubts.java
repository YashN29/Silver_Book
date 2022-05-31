package com.example.studypartner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Show_doubts extends Fragment {

    ApiInterface apiInterface;
    RecyclerView view_doubts;
    Doubts_Adapter doubtsAdapter;
//    MaterialButton delete_doubts;
    List<Doubts_Model> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_show_doubts,container,false);

//        delete_doubts = v.findViewById(R.id.delete_doubts);
        view_doubts = v.findViewById(R.id.view_doubts);
        view_doubts.setHasFixedSize(true);
        view_doubts.setLayoutManager(new LinearLayoutManager(getContext()));

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.getDoubt().enqueue(new Callback<List<Doubts_Model>>() {
            @Override
            public void onResponse(Call<List<Doubts_Model>> call, Response<List<Doubts_Model>> response) {
                list = response.body();
                doubtsAdapter = new Doubts_Adapter(getContext(),list);
                view_doubts.setAdapter(doubtsAdapter);
            }

            @Override
            public void onFailure(Call<List<Doubts_Model>> call, Throwable t) {

            }
        });

//        delete_doubts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                apiInterface.deleteDoubts().enqueue(new Callback<List<Doubts_Model>>() {
//                    @Override
//                    public void onResponse(Call<List<Doubts_Model>> call, Response<List<Doubts_Model>> response) {
//                        Toast.makeText(getContext(), "Deleted Successfully!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Doubts_Model>> call, Throwable t) {
//
//                    }
//                });
//            }
//        });


        return v;
    }
}