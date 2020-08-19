package com.example.testapplication;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class FishListFragmentPresenter extends MvpPresenter<FishListFragmentView> {

    public FishListFragmentPresenter() {}

    public void onAddFishClick(){
        getViewState().addFish();
    }

}
