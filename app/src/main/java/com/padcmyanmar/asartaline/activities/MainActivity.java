package com.padcmyanmar.asartaline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.adapters.WarDeeAdapter;
import com.padcmyanmar.asartaline.data.models.WarDeeModel;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements WarDeeDelegate,SearchView.OnQueryTextListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_war_dee)
    RecyclerView rvWarDee;

    @BindView(R.id.sv_wardee)
    SearchView searchView;

    private WarDeeAdapter mWarDeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        mWarDeeAdapter = new WarDeeAdapter(this);
        rvWarDee.setAdapter(mWarDeeAdapter);
        rvWarDee.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        WarDeeModel.getObjInstance().loadWarDeeList();

        searchView.setOnQueryTextListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onTapImage(ASTLWarDeeVO warDee) {
        Intent intent = new Intent(getApplicationContext(), WarDeeDetailActivity.class);
        intent.putExtra("warDeeId", warDee.getWarDeeId());
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {
        Log.d("onSuccessGetWarDee", "onSuccessGetWarDee :" + event.getWarDeeList());
        mWarDeeAdapter.setWarDeeList(event.getWarDeeList());
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mWarDeeAdapter.getFilter().filter(newText);
        return true;
    }
}
