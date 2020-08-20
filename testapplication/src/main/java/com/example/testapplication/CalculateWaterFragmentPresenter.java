package com.example.testapplication;

import moxy.InjectViewState;
import moxy.MvpPresenter;

import static java.lang.Math.abs;

@InjectViewState
public class CalculateWaterFragmentPresenter extends MvpPresenter<CalculateWaterFragmentView> {

    public CalculateWaterFragmentPresenter() {
    }

    public void onCountClick(float aquariumValue, float aquariumTemperature, float wishTemperature, float haveTemperature) {
        float result = calculateWaterTemperature(aquariumValue, aquariumTemperature, haveTemperature, wishTemperature);
        if (result == -1) {
            getViewState().printError(R.string.unreal_temperature);
        } else {
            getViewState().printResult(String.valueOf(result));
        }
    }

    private float calculateWaterTemperature(float m, float t1, float t2, float t) {
        if (t2 == t1) {
            if (t1 == t) {
                return 0;
            } else {
                return -1;
            }
        }
        float mRes = (m * (t - t1)) / (t2 - t1);

        if ((mRes > m) || (mRes < 0)) {
            return -1;
        } else {
            return abs(mRes);
        }

    }
}
