package com.joey.pattern.factory.func;

import com.joey.pattern.factory.Milk;
import com.joey.pattern.factory.YiLiMilk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class YiliMilkFactory implements MilkFactory {
    @Override
    public Milk getMilk() {
        return new YiLiMilk();
    }
}
