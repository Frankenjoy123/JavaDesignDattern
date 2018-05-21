package com.joey.pattern.factory.abs;

import com.joey.pattern.factory.*;
import com.joey.pattern.factory.func.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class AbsMilkFactoryImpl extends AbsMilkFactory {

    //抽象工厂
    //也可以和工厂方法结合使用

    @Override
    public Milk getMengniu() {
//        return new MengniuMilk();

        MilkFactory factory = new MengniuMilkFactory();
        return factory.getMilk();
    }

    @Override
    public Milk getYili() {
//        return new YiLiMilk();

        MilkFactory factory = new YiliMilkFactory();
        return factory.getMilk();
    }

    @Override
    public Milk getTelunsu() {
//        return new TelunsuMilk();

        MilkFactory factory = new TelunsuMilkFactory();
        return factory.getMilk();
    }

    @Override
    public Milk getGuangming() {
//        return new GuangmingMilk();

        MilkFactory factory = new GuangmingMilkFactory();
        return factory.getMilk();
    }

}
