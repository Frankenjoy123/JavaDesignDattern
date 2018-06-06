package com.joey.pattern.observe.core;


import java.lang.reflect.Method;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class Event {

    //事件源
    private Object source;

    //通知目标
    private Object target;

    //回调
    private Method callback;

    //触发
    private String trigger;

    private long timestamp;

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
