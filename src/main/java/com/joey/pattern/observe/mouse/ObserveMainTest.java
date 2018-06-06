package com.joey.pattern.observe.mouse;

import com.joey.pattern.observe.core.Event;

import java.lang.reflect.Method;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class ObserveMainTest {

    public static void main(String[] args) {

        //事件源
        Mouse mouse = new Mouse();



        try {
            MouseCallback mouseCallback = new MouseCallback();

            Method click = MouseCallback.class.getMethod("onClick" , Event.class);

            mouse.addListner(MouseEventType.ON_CLICK , mouseCallback , click);

            mouse.click();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
