package com.padcmyanmar.asartaline.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.models.WarDeeModel;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeDetailActivity extends BaseActivity{

    @BindView(R.id.iv_wardee_backdrop)
    ImageView ivBackDrop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_detail);
        ButterKnife.bind(this, this);

        String warDeeId = getIntent().getStringExtra("warDeeId");

        ASTLWarDeeVO warDees = WarDeeModel.getObjInstance().getWarDeeById(warDeeId);
        bindData(warDees);
    }

    private void bindData(ASTLWarDeeVO warDees) {
        if (!warDees.getImages().isEmpty()){
            GlideApp.with(ivBackDrop.getContext())
                    .load(warDees.getImages().get(0))
                    .into(ivBackDrop);
        }else {
            ivBackDrop.setVisibility(View.GONE);
        }

    }
}
