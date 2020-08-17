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


/*public class Fragment_1 extends MvpAppCompatFragment implements Fragment_1View {
    //public static final String ARGS_REPOSITORY = "argsRepository";

    @InjectPresenter
    Fragment_1Presenter mFragment_1Presenter;

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

//    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
//        mCountButton.setOnClickListener(v -> mFragment_1Presenter.onCountClick());
    }

    @Override
    public void countWater() {
        mAnswerView.setText(String.valueOf(12));
    }

    //    private Repository mRepository;
//
//    @BindView(R.id.fragment_repository_details_text_view_title)
//    RepositoryWidget mTitleTextView;
//    @BindView(R.id.fragment_repository_details_image_button_like)
//    ImageButton mLikeImageButton;
//
//    @ProvidePresenter
//    RepositoryPresenter provideRepositoryPresenter() {
//        mRepository = (Repository) getArguments().get(ARGS_REPOSITORY);
//
//        return new RepositoryPresenter(mRepository);
//    }
//
//    public static DetailsFragment getInstance(Repository repository) {
//        DetailsFragment fragment = new DetailsFragment();
//
//        Bundle args = new Bundle();
//        args.putSerializable(ARGS_REPOSITORY, repository);
//
//        fragment.setArguments(args);
//
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_2, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        ButterKnife.bind(this, view);
//
//        mLikeImageButton.setOnClickListener(likeImageButton -> mRepositoryLikesPresenter.toggleLike(mRepository.getId()));
//    }
}*/

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
        Log.v("===>", "On create view");
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        unbinder = ButterKnife.bind(this, view);
//        mCountButton.
        return view;
    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @OnClick(R.id.btCount)
    void onCountClick() {
        Log.v("===>", "Button press");
        mFragment_1Presenter.onCountClick();
    }

    @Override
    public void countWater() {
        mAnswerView.setText(String.valueOf(12));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

