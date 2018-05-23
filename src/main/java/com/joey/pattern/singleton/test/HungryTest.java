package com.joey.pattern.singleton.test;

import com.joey.pattern.singleton.hungry.HungryEntity;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/22.
 */
public class HungryTest {
    public static void main(String[] args) {
        HungryEntity entity = HungryEntity.getInstance();
        System.out.printf(entity.toString());
    }
}
