package com.example.marketstore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketstore.databinding.FragmentProductDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductDetail extends Fragment {

    FragmentProductDetailBinding binding;

    public FragmentProductDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        if (getArguments() != null) {
            Product product = FragmentProductDetailArgs.fromBundle(getArguments()).getProduct();

            binding.textViewProduct.setText(product.getProduct());
            binding.textViewPrice.setText(String.valueOf(product.getProduct()));
            binding.textViewLongDescription.setText(product.getLongDescription());


        }

        return v;
    }


}
