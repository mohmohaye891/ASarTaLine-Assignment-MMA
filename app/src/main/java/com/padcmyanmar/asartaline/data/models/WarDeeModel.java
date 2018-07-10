package com.padcmyanmar.asartaline.data.models;

import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline.network.RetrofitDataAgentImpl;
import com.padcmyanmar.asartaline.network.WarDeeDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class WarDeeModel {

    private static WarDeeModel objInstance;

    private WarDeeDataAgent mDataAgent;

    private Map<String, ASTLWarDeeVO> mWarDeeMap;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private WarDeeModel(){
        mDataAgent = RetrofitDataAgentImpl.getInstance();

        mWarDeeMap = new HashMap<>();

        EventBus.getDefault().register(this);
    }

    public static WarDeeModel getObjInstance(){
        if (objInstance == null){
            objInstance = new WarDeeModel();
        }
        return objInstance;
    }

    public void loadWarDeeList(){
        mDataAgent.loadWarDeeList(DUMMY_ACCESS_TOKEN);
    }

    public ASTLWarDeeVO getWarDeeById(String warDeeId){
        return mWarDeeMap.get(warDeeId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event){
       for (ASTLWarDeeVO warDee : event.getWarDeeList()){
           mWarDeeMap.put(warDee.getWarDeeId(), warDee);
       }
    }
}
