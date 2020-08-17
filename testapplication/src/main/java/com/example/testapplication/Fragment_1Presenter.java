package com.example.testapplication;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class Fragment_1Presenter extends MvpPresenter<Fragment_1View> {

    public Fragment_1Presenter() {
//        getViewState().countWater();
    }

    public void onCountClick() {
        getViewState().countWater();
    }
}
