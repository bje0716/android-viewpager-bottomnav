package com.grapefruit.bottomviewpager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.grapefruit.bottomviewpager.databinding.ViewTwoBinding;

public class FragmentTwo extends Fragment {

    private String parameter;

    public static FragmentTwo newInstance(String parameter) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString("parameter", parameter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            parameter = getArguments().getString("parameter");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewTwoBinding binding = ViewTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
