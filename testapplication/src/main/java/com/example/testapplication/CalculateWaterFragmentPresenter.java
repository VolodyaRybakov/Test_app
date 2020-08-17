package com.example.testapplication;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class CalculateWaterFragmentPresenter extends MvpPresenter<CalculateWaterFragmentView> {

    public CalculateWaterFragmentPresenter() {
//        getViewState().countWater();
    }

    public void onCountClick() {
        Log.v("===>", "onCountClick");
        getViewState().countWater();
    }
}
