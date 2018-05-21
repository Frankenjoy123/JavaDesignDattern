package com.joey.pattern.factory.func;

import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class FuncFactoryTest {

    public static void main(String[] args) {

        //工厂方法，一种工厂只生产一种产品
//        MilkFactory factory = new TelunsuMilkFactory();

        MilkFactory factory = new GuangmingMilkFactory();

        Milk milk = factory.getMilk();

        System.out.printf(milk.getName());
    }
}
