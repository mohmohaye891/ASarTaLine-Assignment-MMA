package com.padcmyanmar.asartaline.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.adapters.WarDeeAdapter;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;

public class MainActivity extends AppCompatActivity implements WarDeeDelegate{

    private WarDeeAdapter mWarDeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvWarDee = findViewById(R.id.rv_war_dee);
        mWarDeeAdapter = new WarDeeAdapter(this);
        rvWarDee.setAdapter(mWarDeeAdapter);
        rvWarDee.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onTapImage() {
        Intent intent = new Intent(getApplicationContext(), WarDeeDetailActivity.class);
        startActivity(intent);
    }
}
