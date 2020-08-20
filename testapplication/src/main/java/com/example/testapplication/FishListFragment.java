package com.example.testapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

import static android.content.Context.MODE_PRIVATE;

public class FishListFragment extends MvpAppCompatFragment implements FishListFragmentView, RemoveClickListener, AddFishClickListener {

    @InjectPresenter
    FishListFragmentPresenter mFishListFragmentPresenter;

    private Unbinder unbinder;
    private FishAdapter adapter;
    private AlertDialog dialog;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.add_fish)
    FloatingActionButton mAddFishButton;


    ArrayList<Fish> fishes = new ArrayList<>();
    final ArrayList<Fish> defaultFishList = new ArrayList(Arrays.asList(new Fish("Заглушка", 0, 0, "?")));
    private ArrayList<String> fishKinds = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fish_list_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);

        adapter = new FishAdapter(getContext(), fishes, this);
        mRecyclerView.setAdapter(adapter);

        fishes = mFishListFragmentPresenter.loadFishList(getActivity().getPreferences(MODE_PRIVATE));
        fishKinds = mFishListFragmentPresenter.loadFishKindsList(getActivity().getPreferences(MODE_PRIVATE));
        if (fishes.size() == 0) {
            adapter.notifyData(defaultFishList);
        } else {
            adapter.notifyData(fishes);
        }

        return view;
    }

    @OnClick(R.id.add_fish)
    void onAddFishClick() {
        mFishListFragmentPresenter.onAddFishClick();
    }

    @Override
    public void addFish() {
        dialog = AddFishDialog.getDialog(getActivity(), this, fishKinds);
        dialog.show();
    }

    @Override
    public void onAddFishInDialogClick(String name, float length, float height, String kind) {
        fishKinds.add(kind);
        fishes.add(new Fish(name, length, height, kind));
        adapter.notifyData(fishes);
        mFishListFragmentPresenter.saveFishList(getActivity().getPreferences(MODE_PRIVATE), fishes);
        mFishListFragmentPresenter.saveFishKindsList(getActivity().getPreferences(MODE_PRIVATE), fishKinds);
    }

    @Override
    public void OnRemoveClick(int index) {
        if (fishes.size() > 1) {
            fishes.remove(index);
            adapter.notifyData(fishes);
        } else if (fishes.size() == 1) {
            fishes.remove(index);
            adapter.notifyData(defaultFishList);
        } else {
            adapter.notifyData(defaultFishList);
        }
        mFishListFragmentPresenter.saveFishList(getActivity().getPreferences(MODE_PRIVATE), fishes);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}