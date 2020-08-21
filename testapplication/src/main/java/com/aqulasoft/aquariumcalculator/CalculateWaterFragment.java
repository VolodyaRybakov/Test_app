package com.aqulasoft.aquariumcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class CalculateWaterFragment extends MvpAppCompatFragment implements CalculateWaterFragmentView {

    @InjectPresenter
    CalculateWaterFragmentPresenter mCalculateWaterFragmentPresenter;

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
    @BindView(R.id.tvAnswer)
    TextView mAnswerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.calculate_water_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btCount)
    void onCountClick() {
        try {
            mCalculateWaterFragmentPresenter.onCountClick(Float.parseFloat(String.valueOf(mAquariumValueView.getText())),
                    Float.parseFloat(String.valueOf(mAquariumTemperatureView.getText())),
                    Float.parseFloat(String.valueOf(mWishTemperatureView.getText())),
                    Float.parseFloat(String.valueOf(mHasTemperatureView.getText())));
        } catch (NumberFormatException e){
            printError(R.string.not_enough_data);
        }
    }

    @Override
    public void printResult(String value) {
        mAnswerView.setText(value);
    }

    @Override
    public void printError(int message) {
        if (isAdded()) {
            Toast.makeText(getContext(),
                    message,
                    Toast.LENGTH_SHORT).show();
        }
        final SpannableStringBuilder text = new SpannableStringBuilder("-");
        final ForegroundColorSpan style = new ForegroundColorSpan(Color.rgb(255, 0, 0));
        text.setSpan(style, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mAnswerView.setText(text);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

}

