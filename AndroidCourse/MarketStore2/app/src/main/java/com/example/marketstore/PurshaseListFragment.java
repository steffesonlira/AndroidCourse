package com.example.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketstore.databinding.FragmentProductDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurshaseListFragment extends Fragment {


    public PurshaseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_purshase_list, container, false);
    }


}
