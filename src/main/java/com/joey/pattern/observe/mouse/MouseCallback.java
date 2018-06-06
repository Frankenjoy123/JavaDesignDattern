package com.joey.pattern.observe.mouse;

import com.joey.pattern.observe.core.Event;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class MouseCallback {

    public void onClick(Event event){
        System.out.println("========监听器do click===========");
    }

    public void onDoubleClick(Event event){
        System.out.println("========do double click");
    }
    public void onDown(Event event){
        System.out.println("========do down");
    }
    public void on(Event event){
        System.out.println("========do on");
    }

    public void onMove(Event event){
        System.out.println("========do move");
    }

    public void onWheel(Event event){
        System.out.println("========do wheel");
    }
}
