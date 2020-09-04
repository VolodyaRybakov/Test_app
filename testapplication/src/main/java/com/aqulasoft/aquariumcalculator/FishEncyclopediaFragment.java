package com.aqulasoft.aquariumcalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class FishEncyclopediaFragment extends MvpAppCompatFragment implements FishEncyclopediaFragmentView {

    @InjectPresenter
    FishEncyclopediaFragmentPresenter mFishEncyclopediaFragmentPresenter;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fish_encyclopedia_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

}