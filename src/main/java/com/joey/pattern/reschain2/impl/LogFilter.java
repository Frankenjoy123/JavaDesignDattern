package com.joey.pattern.reschain2.impl;

import com.joey.pattern.reschain2.Filter;
import com.joey.pattern.reschain2.Invoker;

import java.io.File;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public class LogFilter implements Filter{
    @Override
    public String invoke(Invoker invoker, String invocation) {

        System.out.println("Log Filter do logging");

        return invoker.invoke(invocation);
    }
}
