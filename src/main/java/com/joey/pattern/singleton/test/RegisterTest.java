package com.joey.pattern.singleton.test;

import com.joey.pattern.singleton.hungry.HungryEntity;
import com.joey.pattern.singleton.register.Entity;
import com.joey.pattern.singleton.register.RegisterFactory;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/26.
 */
public class RegisterTest {

    public static void main(String[] args) {

        System.out.println(Entity.class.getName());
        Object object = RegisterFactory.getInstance(Entity.class.getName());

        System.out.println(object);

    }
}
