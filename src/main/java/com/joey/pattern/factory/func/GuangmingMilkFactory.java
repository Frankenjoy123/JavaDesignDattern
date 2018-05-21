package com.joey.pattern.factory.func;

import com.joey.pattern.factory.GuangmingMilk;
import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class GuangmingMilkFactory implements MilkFactory {
    @Override
    public Milk getMilk() {
        return new GuangmingMilk();
    }
}
