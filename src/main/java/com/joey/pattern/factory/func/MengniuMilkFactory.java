package com.joey.pattern.factory.func;

import com.joey.pattern.factory.MengniuMilk;
import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class MengniuMilkFactory implements MilkFactory {

    @Override
    public Milk getMilk() {
        return new MengniuMilk();
    }
}
