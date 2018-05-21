package com.joey.pattern.factory.abs;

import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public abstract class AbsMilkFactory {

    //抽象工厂
    public abstract Milk getMengniu();

    public abstract Milk getYili();

    public abstract Milk getTelunsu();

    public abstract Milk getGuangming();
}
