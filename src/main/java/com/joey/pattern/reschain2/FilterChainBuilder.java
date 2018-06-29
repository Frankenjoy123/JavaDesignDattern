package com.joey.pattern.reschain2;

import com.joey.pattern.reschain2.impl.LogFilter;
import com.joey.pattern.reschain2.impl.TimeFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public class FilterChainBuilder {

    public static Invoker build(Invoker originInvoker){

        List<Filter> filterList = new ArrayList<>();
        filterList.add(new LogFilter());
        filterList.add(new TimeFilter());

        Invoker last = originInvoker;

        for (Filter filter : filterList){

            Invoker next = last;

            last = new Invoker() {

                @Override
                public String invoke(String invocation) {

                    return filter.invoke(next , invocation);
                }
            };

        }


        return last;
    }
}
