package com.padcmyanmar.asartaline.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.data.vos.SearchResultsVO;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeViewHolder extends RecyclerView.ViewHolder {

    private WarDeeDelegate mWarDeeDelegate;

    private ASTLWarDeeVO mWarDee;

    @BindView(R.id.iv_shop)
    ImageView ivShop;

    @BindView(R.id.tv_item_name)
    TextView tvItemName;

    @BindView(R.id.tv_item_country)
    TextView tvItemCountry;

    @BindView(R.id.tv_item_cost)
    TextView tvItemCost;


    public WarDeeViewHolder(View itemView, WarDeeDelegate warDeeDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mWarDeeDelegate = warDeeDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mWarDeeDelegate.onTapImage(mWarDee);
            }
        });
    }

    public void setWarDeeData(ASTLWarDeeVO warDee){
        mWarDee = warDee;
        tvItemName.setText(warDee.getName());
        tvItemCost.setText(warDee.getPriceRangeMax());
        //tvItemCountry.setText(warDee.getSuitedFor());

        if (!warDee.getImages().isEmpty()){
            GlideApp.with(ivShop.getContext())
                    .load(warDee.getImages().get(0))
                    .into(ivShop);
        }else {
            ivShop.setVisibility(View.GONE);
        }
    }

}
