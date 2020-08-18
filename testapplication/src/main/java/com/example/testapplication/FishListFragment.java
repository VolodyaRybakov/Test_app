package com.example.testapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class FishListFragment extends MvpAppCompatFragment implements FishListFragmentView {

    @InjectPresenter
    FishListFragmentPresenter mFishListFragmentPresenter;

    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

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

        unbinder = ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Fish> fishes = new ArrayList<Fish>();
        fishes.add(new Fish("1", 1, 1, "1"));
        fishes.add(new Fish("2", 2, 2, "2"));
        fishes.add(new Fish("3", 3, 3, "3"));
        fishes.add(new Fish("4", 4, 4, "4"));

        FishAdapter fishAdapter = new FishAdapter(fishes);

        mRecyclerView.setAdapter(fishAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}