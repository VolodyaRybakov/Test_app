package com.example.testapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface CalculateWaterFragmentView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void countWater();
}
