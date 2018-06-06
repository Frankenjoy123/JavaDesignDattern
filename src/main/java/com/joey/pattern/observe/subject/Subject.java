package com.joey.pattern.observe.subject;

import com.joey.pattern.observe.core.EventListner;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class Subject extends EventListner{

    public void add(){
        System.out.println("调用添加方法");

        this.trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除方法");

        this.trigger(SubjectEventType.ON_REMOVE);

    }
}
