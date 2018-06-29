package com.joey.pattern.reschain2.impl;

import com.joey.pattern.reschain2.Filter;
import com.joey.pattern.reschain2.Invoker;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public class TimeFilter implements Filter{

    @Override
    public String invoke(Invoker invoker, String invocation) {

        System.out.println("time filter doing work");

        return invoker.invoke(invocation);
    }
}
