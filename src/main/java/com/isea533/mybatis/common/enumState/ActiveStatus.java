package com.isea533.mybatis.common.enumState;

/**
 * Created by dell on 2016/10/31.
 */
public enum ActiveStatus {
    Active(0, "无效"), UnActive(1, "有效");

    private int state;
    private String desc;

    private ActiveStatus(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public static String getDesc(int state){
        for(ActiveStatus data : ActiveStatus.values()){
            if(data.getState() == state)
                return data.getDesc();
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
