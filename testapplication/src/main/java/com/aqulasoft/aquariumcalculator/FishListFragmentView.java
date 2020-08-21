package com.aqulasoft.aquariumcalculator;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface FishListFragmentView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void addFish();
}
