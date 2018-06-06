package com.joey.pattern.observe.subject;

import com.joey.pattern.observe.core.Event;

import java.lang.reflect.Method;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/6.
 */
public class SubjectTest {

    public static void main(String[] args) {


        Subject subject = new Subject();


        try {
            Observer observer = new Observer();

            Method method = Observer.class.getMethod("advice", Event.class);

            subject.addListner(SubjectEventType.ON_ADD , observer , method);

            subject.addListner(SubjectEventType.ON_EDIT , observer , method);

            subject.addListner(SubjectEventType.ON_REMOVE , observer , method);

            subject.addListner(SubjectEventType.ON_QUERY , observer , method);



            subject.add();
            subject.remove();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
