package com.aqulasoft.aquariumcalculator;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface CalculateWaterFragmentView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void printResult(String value);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void printError(int message);
}
