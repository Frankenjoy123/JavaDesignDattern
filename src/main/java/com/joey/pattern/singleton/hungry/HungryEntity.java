package com.joey.pattern.singleton.hungry;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/22.
 */
public class HungryEntity {

    private static HungryEntity hungryEntity = new HungryEntity();

    private HungryEntity() {

    }

    public static HungryEntity getInstance(){
        return hungryEntity;
    }

}
