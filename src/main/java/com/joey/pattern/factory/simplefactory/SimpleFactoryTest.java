package com.joey.pattern.factory.simplefactory;

import com.joey.pattern.factory.Milk;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        //简单工程，什么三无产品都能生产
        SimpleFactory factory = new SimpleFactory();

//        Milk milk = factory.getMilk("蒙牛");

        Milk milk = factory.getMilk("光明");

        System.out.printf(milk.getName());
    }
}
