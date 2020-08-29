package com.aqulasoft.aquariumcalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {

    private final Random mRandom;
    private LayoutInflater inflater;
    private ArrayList<Fish> fishes;
    private RemoveClickListener mListener;

    public FishAdapter(Context context, ArrayList<Fish> fishes, FishListFragment listener){
        this.fishes = fishes;
        this.inflater = LayoutInflater.from(context);
        mListener = listener;
        mRandom = new Random();
    }

    @NonNull
    @Override
    public FishAdapter.FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new FishViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        Fish fish = fishes.get(position);

        int r = mRandom.nextInt(3);
        switch (r) {
            case 1:
                holder.mImage.setImageResource(R.drawable.ic_fish_2);
                break;
            case 2:
                holder.mImage.setImageResource(R.drawable.ic_fish_3);
                break;
            default:
                holder.mImage.setImageResource(R.drawable.ic_fish_1);
        }

        holder.mFishNameView.setText(fish.getName());
        holder.mFishSizeTextView.setText(String.format("%.0f x %.0f", fish.getHeight(), fish.getLength()));
        holder.mFishKindView.setText(fish.getKind());
    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }

    public void notifyData(ArrayList<Fish> fishes) {
        this.fishes = fishes;
        notifyDataSetChanged();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemFishNameTextView)
        TextView mFishNameView;
        @BindView(R.id.itemFishSizeContentTexView)
        TextView mFishSizeTextView;
        @BindView(R.id.itemFishKindContentTexView)
        TextView mFishKindView;
        @BindView(R.id.deleteButton)
        AppCompatImageButton mDeleteButton;
        @BindView(R.id.itemFishImage)
        ImageView mImage;

        public FishViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            mDeleteButton.setOnClickListener(view1 -> mListener.OnRemoveClick(getAdapterPosition()));
        }
    }
}
