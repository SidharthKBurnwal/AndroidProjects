package com.example.android.fragmentabinterface;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class FragmentA extends Fragment implements View.OnClickListener{

    Button button;
    int counter = 0;
    Communicator comm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator)getActivity();
        button = (Button)getActivity().findViewById(R.id.txtButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter ++;
        comm.respond("Number of clicks "+counter);
    }
}
