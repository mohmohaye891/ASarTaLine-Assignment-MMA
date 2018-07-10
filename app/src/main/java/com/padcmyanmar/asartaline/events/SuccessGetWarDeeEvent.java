package com.padcmyanmar.asartaline.events;

import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;

import java.util.List;

public class SuccessGetWarDeeEvent {

    private List<ASTLWarDeeVO> warDeeList;

    public SuccessGetWarDeeEvent(List<ASTLWarDeeVO> warDeeList) {
        this.warDeeList = warDeeList;
    }

    public List<ASTLWarDeeVO> getWarDeeList() {
        return warDeeList;
    }
}
