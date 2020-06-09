package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public static final String FRAGEMENT2_MESSAGE = "FRAG2_MSG";

    TextView messageTextView;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String message){
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGEMENT2_MESSAGE, message);
        secondFragment.setArguments(bundle);
        return secondFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        messageTextView = v.findViewById(R.id.fragment2_textview);

        if(getArguments() != null){
            Bundle bundle = getArguments();
            messageTextView.setText(bundle.getString(FRAGEMENT2_MESSAGE));
        }
        return v;
    }
}