package com.isea533.mybatis.common.enumState;

/**
 * Created by dell on 2016/11/22.
 */
public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;

    private State(final String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return this.state;
    }

    public String getName(){
        return this.name();
    }
}
