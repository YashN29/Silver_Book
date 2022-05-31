package com.example.studypartner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Sem_1 extends Fragment {

    MaterialButton sumbit;
    EditText ed_type;

    AppCompatSpinner sp;

    ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sem_1,container,false);

        sp = v.findViewById(R.id.spdata);

        ed_type = v.findViewById(R.id.ed_type);
        sumbit = v.findViewById(R.id.submit);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ed_type.getText().equals("") && sp.getSelectedItem().equals(""))
                {
                    Toast.makeText(getContext(), "Please Enter Valid Doubts!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                    Call<Doubts_Model> call = apiInterface.addDoubts(ed_type.getText().toString());

                    call.enqueue(new Callback<Doubts_Model>() {
                        @Override
                        public void onResponse(Call<Doubts_Model> call, Response<Doubts_Model> response) {
                            Toast.makeText(getContext(), "Successfully Submitted!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Doubts_Model> call, Throwable t) {

                        }
                    });
                }
                ed_type.getText().clear();

            }
        });



        return v;
    }
}