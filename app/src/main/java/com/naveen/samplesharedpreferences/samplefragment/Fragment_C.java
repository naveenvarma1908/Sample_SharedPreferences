package com.naveen.samplesharedpreferences.samplefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.naveen.samplesharedpreferences.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_C extends Fragment {



    private Button button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__c, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        button = (Button)getActivity().findViewById(R.id.bn_click);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
