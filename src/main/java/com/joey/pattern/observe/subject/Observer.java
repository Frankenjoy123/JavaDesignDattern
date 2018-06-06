package com.joey.pattern.observe.subject;

import com.joey.pattern.observe.core.Event;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class Observer {

    public void advice(Event event){
        System.out.println("=====触发事件，打印日志==========\n");
    }

}
