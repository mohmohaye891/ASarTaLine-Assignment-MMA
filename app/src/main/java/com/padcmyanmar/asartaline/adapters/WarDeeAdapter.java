package com.padcmyanmar.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.viewholders.WarDeeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WarDeeAdapter extends RecyclerView.Adapter<WarDeeViewHolder>{

    private WarDeeDelegate mWarDeeDelegate;

    private List<ASTLWarDeeVO> mWarDeeList;


    public WarDeeAdapter(WarDeeDelegate mWarDeeDelegate) {
        this.mWarDeeDelegate = mWarDeeDelegate;
        mWarDeeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public WarDeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_item_food, parent, false);
        return new WarDeeViewHolder(view, mWarDeeDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull WarDeeViewHolder holder, int position) {
        holder.setWarDeeData(mWarDeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWarDeeList.size();
    }

    public void setWarDeeList(List<ASTLWarDeeVO> warDeeList){
        mWarDeeList = warDeeList;
        notifyDataSetChanged();
    }
}
