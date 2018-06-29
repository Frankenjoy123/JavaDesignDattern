package com.joey.pattern.reschain2;

import com.joey.pattern.reschain2.impl.MyInvoker;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public class MainTest {

    public static void main(String[] args) {

        Invoker jobInvoker = new MyInvoker();

        Invoker chainFilterInvoker = FilterChainBuilder.build(jobInvoker);


        String result = chainFilterInvoker.invoke("hello world");

        System.out.println(result);

    }
}
