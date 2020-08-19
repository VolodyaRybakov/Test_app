package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Fish> fishes;

    public FishAdapter(Context context, ArrayList<Fish> fishes){
        this.fishes = fishes;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FishAdapter.FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        Fish fish = fishes.get(position);
        holder.mFishNamdeView.setText(fish.getName());
        holder.mFishHeightView.setText(String.valueOf(fish.getHeight()));
        holder.mFishLenghtView.setText(String.valueOf(fish.getLength()));
        holder.mFishKindView.setText(fish.getKind());
    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView mFishNamdeView;
        @BindView(R.id.height)
        TextView mFishHeightView;
        @BindView(R.id.length)
        TextView mFishLenghtView;
        @BindView(R.id.kind)
        TextView mFishKindView;

        public FishViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
