package com.joey.pattern.observe.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class EventListner {

    Map<Enum , Event> eventMap = new HashMap<>();


    public void addListner(Enum eventType , Object target , Method callback){

        eventMap.put(eventType , new Event(target , callback));
    }


    private void trigger(Event event){

        event.setSource(event);
        event.setTimestamp(System.currentTimeMillis());

        try {
            event.getCallback().invoke(event.getTarget() , event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



    protected void trigger(Enum call){

        if (!this.eventMap.containsKey(call)){
            return;
        }

        trigger(eventMap.get(call).setTrigger(call.toString()));

    }


}
