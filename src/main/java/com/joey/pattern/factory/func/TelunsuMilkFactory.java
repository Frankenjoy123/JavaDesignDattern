package com.joey.pattern.factory.func;

import com.joey.pattern.factory.Milk;
import com.joey.pattern.factory.TelunsuMilk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class TelunsuMilkFactory implements MilkFactory {
    @Override
    public Milk getMilk() {
        return new TelunsuMilk();
    }
}
