package com.padcmyanmar.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.viewholders.WarDeesViewHolder;

public class WarDeeAdapter extends RecyclerView.Adapter<WarDeesViewHolder>{

    private WarDeeDelegate mWarDeeDelegate;

    public WarDeeAdapter(WarDeeDelegate mWarDeeDelegate) {
        this.mWarDeeDelegate = mWarDeeDelegate;
    }

    @NonNull
    @Override
    public WarDeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_item_food, parent, false);
        return new WarDeesViewHolder(view, mWarDeeDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull WarDeesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
