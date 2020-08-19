package com.example.testapplication;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class FishListFragment extends MvpAppCompatFragment implements FishListFragmentView {

    @InjectPresenter
    FishListFragmentPresenter mFishListFragmentPresenter;

    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.add_fish)
    FloatingActionButton mAddFishButton;

    ArrayList<Fish> fishes = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("===>", "On create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fish_list_fragment, container, false);

        setInitialData();

        unbinder = ButterKnife.bind(this, view);

        FishAdapter adapter = new FishAdapter(getContext(), fishes);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    private void setInitialData(){
        fishes.add(new Fish("1", 1, 1, "1"));
        fishes.add(new Fish("2", 2, 2, "2"));
        fishes.add(new Fish("3", 3, 3, "3"));
        fishes.add(new Fish("4", 4, 4, "4"));
    }

    @OnClick(R.id.add_fish)
    void onAddFishClick() {
        mFishListFragmentPresenter.onAddFishClick();
    }

    @Override
    public void addFish(){
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Вы нажали на кнопочку",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}