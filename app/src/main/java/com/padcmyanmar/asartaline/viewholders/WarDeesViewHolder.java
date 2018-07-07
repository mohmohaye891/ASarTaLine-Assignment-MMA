package com.padcmyanmar.asartaline.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;

public class WarDeesViewHolder extends RecyclerView.ViewHolder {

    private WarDeeDelegate mWarDeeDelegate;

    public WarDeesViewHolder(View itemView, WarDeeDelegate warDeeDelegate) {
        super(itemView);
        mWarDeeDelegate = warDeeDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mWarDeeDelegate.onTapImage();
            }
        });
    }
}
