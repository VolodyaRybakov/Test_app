package com.example.testapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
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
        View view = inflater.inflate(R.layout.calculate_water_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }


    @OnClick(R.id.btCount)
    void onCountClick() {
        try {
            mCalculateWaterFragmentPresenter.onCountClick(Float.parseFloat(String.valueOf(mAquariumValueView.getText())),
                    Float.parseFloat(String.valueOf(mAquariumTemperatureView.getText())),
                    Float.parseFloat(String.valueOf(mWishTemperatureView.getText())),
                    Float.parseFloat(String.valueOf(mHasTemperatureView.getText())));
        } catch (NumberFormatException e){
            printError("Недостаточно данных для проведения расчётов");
        }
    }

    @Override
    public void printResult(String value) {
        mAnswerView.setText(value);
    }

    @Override
    public void printError(String message) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.show();
        final SpannableStringBuilder text = new SpannableStringBuilder("-");
        final ForegroundColorSpan style = new ForegroundColorSpan(Color.rgb(255, 0, 0));
        text.setSpan(style, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mAnswerView.setText(text);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
