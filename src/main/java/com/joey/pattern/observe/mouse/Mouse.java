package com.joey.pattern.observe.mouse;

import com.joey.pattern.observe.core.EventListner;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class Mouse extends EventListner{

    public void click(){
        System.out.println("click");

        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println("double click");

        this.trigger(MouseEventType.ON_DOUBLECLICK);

    }
    public void down(){
        System.out.println("down");

        this.trigger(MouseEventType.ON_DOWN);
    }
    public void on(){
        System.out.println("on");

        this.trigger(MouseEventType.ON_ON);
    }

    public void move(){
        System.out.println("move");

        this.trigger(MouseEventType.ON_MOVE);
    }

    public void wheel(){
        System.out.println("wheel");

        this.trigger(MouseEventType.ON_WHEEL);
    }
}
