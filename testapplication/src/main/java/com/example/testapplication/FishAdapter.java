package com.example.testapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Fish> fishes;
    private RemoveClickListner mListner;

    public FishAdapter(Context context, ArrayList<Fish> fishes, FishListFragment listner){
        this.fishes = fishes;
        this.inflater = LayoutInflater.from(context);
        mListner=listner;
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

    public void notifyData(ArrayList<Fish> fishes) {
        this.fishes = fishes;
        notifyDataSetChanged();
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
        @BindView(R.id.main_layout)
        ConstraintLayout mainLayout;
        @BindView(R.id.deleteButton)
        Button mDeleteButton;


        public FishViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                }
            });

            mDeleteButton.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.OnRemoveClick(getAdapterPosition()
                    );
                }
            });
        }
    }
}
