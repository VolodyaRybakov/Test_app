package com.example.testapplication;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import moxy.InjectViewState;
import moxy.MvpPresenter;

import static android.content.Context.MODE_PRIVATE;

@InjectViewState
public class FishListFragmentPresenter extends MvpPresenter<FishListFragmentView> {

    private SharedPreferences sPref;
    final String SAVED_FISHES = "saved_fishes";
    final String SAVED_KINDS = "saved_kinds";

    public FishListFragmentPresenter() {}

    public void onAddFishClick(){
        getViewState().addFish();
    }

    public void saveFishList(SharedPreferences sPref, ArrayList<Fish> fishes){
        SharedPreferences.Editor ed = sPref.edit();
        String json_fishes = new Gson().toJson(fishes);
        ed.putString(SAVED_FISHES, json_fishes);
        ed.commit();
    }

    public ArrayList<Fish> loadFishList(SharedPreferences sPref) {
        ArrayList<Fish> fishes = new ArrayList<>();
        if(sPref.contains(SAVED_FISHES)) {
            String savedText = sPref.getString(SAVED_FISHES, "");
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Fish>>(){}.getType();
            fishes = gson.fromJson(savedText, type);
        }
        return fishes;
    }

    public void saveFishKindsList(SharedPreferences sPref, ArrayList<String> kinds){
        SharedPreferences.Editor ed = sPref.edit();
        String json_kinds = new Gson().toJson(kinds);
        ed.putString(SAVED_KINDS, json_kinds);
        ed.commit();
    }

    public ArrayList<String> loadFishKindsList(SharedPreferences sPref) {
        ArrayList<String> kinds = new ArrayList<>();
        if(sPref.contains(SAVED_KINDS)) {
            String savedText = sPref.getString(SAVED_KINDS, "");
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>(){}.getType();
            kinds = gson.fromJson(savedText, type);
        }
        return kinds;
    }

}
