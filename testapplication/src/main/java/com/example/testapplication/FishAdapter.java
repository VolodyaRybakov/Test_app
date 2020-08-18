package com.example.testapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {
    ArrayList<Fish> fishes;

    public FishAdapter(ArrayList<Fish> fishes){
        this.fishes = fishes;
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
            Unbinder unbinder = ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.id.list_item, parent, false);
        @SuppressLint("ResourceType") View view = LayoutInflater.from(parent.getContext()).inflate(R.id.list_item, parent, false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        holder.mFishNamdeView.setText(fishes.get(position).getName());
        holder.mFishHeightView.setText(String.valueOf(fishes.get(position).getHeight()));
        holder.mFishLenghtView.setText(String.valueOf(fishes.get(position).getLength()));
        holder.mFishKindView.setText(fishes.get(position).getKind());
    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }
}
