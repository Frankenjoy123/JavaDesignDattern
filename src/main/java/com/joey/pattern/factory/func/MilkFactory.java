package com.joey.pattern.factory.func;

import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public interface MilkFactory {

    //工厂方法，一种工厂只生产一种产品
    public Milk getMilk();
}
