package com.joey.pattern.factory.abs;

import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class AbsMilkFactoryTest {

    public static void main(String[] args) {

        AbsMilkFactory factory =new AbsMilkFactoryImpl();

//        Milk milk = factory.getMengniu();
        Milk milk = factory.getGuangming();

        System.out.println(milk.getName());
    }
}
