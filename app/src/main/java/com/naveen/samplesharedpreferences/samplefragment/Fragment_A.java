package com.naveen.samplesharedpreferences.samplefragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.naveen.samplesharedpreferences.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_A extends Fragment {

    SharedPreferences sharedPreferences;
    EditText username, email, pass, phone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        username = (EditText) getActivity().findViewById(R.id.edit_wUsername);
        email = (EditText) getActivity().findViewById(R.id.edit_wEmail);
        pass = (EditText) getActivity().findViewById(R.id.edit_wPassword);
        phone = (EditText) getActivity().findViewById(R.id.edit_wPhone);


        sharedPreferences = getActivity().getSharedPreferences("Naveen", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Username","");
        String mail = sharedPreferences.getString("Email","");
        String pwd = sharedPreferences.getString("Password","");
        String ph = sharedPreferences.getString("Phone","");

        username.setText(name);
        email.setText(mail);
        pass.setText(pwd);
        phone.setText(ph);
    }
}
