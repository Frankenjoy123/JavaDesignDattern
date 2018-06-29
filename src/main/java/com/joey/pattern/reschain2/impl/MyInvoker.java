package com.joey.pattern.reschain2.impl;

import com.joey.pattern.reschain2.Invoker;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public class MyInvoker implements Invoker{

    @Override
    public String invoke(String invocation) {

        System.out.println("It's my working invoker , doing normal job");
        return "result : " + invocation;
    }
}
