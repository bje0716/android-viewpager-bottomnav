package com.grapefruit.bottomviewpager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.grapefruit.bottomviewpager.databinding.ViewThreeBinding;

public class FragmentThree extends Fragment {

    private String parameter;

    public static FragmentThree newInstance(String parameter) {
        FragmentThree fragment = new FragmentThree();
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
        ViewThreeBinding binding = ViewThreeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
