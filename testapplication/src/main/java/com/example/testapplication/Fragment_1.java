package com.example.testapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class Fragment_1 extends MvpAppCompatFragment implements Fragment_1View {

    @InjectPresenter
    Fragment_1Presenter mFragment_1Presenter;

    private Unbinder unbinder;

    @BindView(R.id.etAquariumValue)
    EditText mAquariumValueView;
    @BindView(R.id.etAquariumTemperature)
    EditText mAquariumTemperatureView;
    @BindView(R.id.etWishTemperature)
    EditText mWishTemperatureView;
    @BindView(R.id.etHaveTemperature)
    EditText mHasTemperatureView;
    @BindView(R.id.btCount)
    Button mCountButton;
    @BindView(R.id.etAnswer)
    EditText mAnswerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("===>", "On create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.v("===>", "On create view");
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }


    @OnClick(R.id.btCount)
    void onCountClick() {
        Log.v("===>", "Button press");
//        mFragment_1Presenter.onCountClick();
        mAnswerView.setText(String.valueOf(12));
    }

    @Override
    public void countWater() {
        Log.v("===>", "countWater");
        mAnswerView.setText(String.valueOf(12));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

