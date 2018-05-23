package com.joey.pattern.singleton.lazy;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/23.
 */
public class LazyTwo {

    private LazyTwo() {
    }

    private static LazyTwo lazyTwo;

    //优点：线程安全
    //缺点：执行效率低（未重现出来）
    public synchronized static LazyTwo getInstance(){

        if (lazyTwo == null){
            lazyTwo = new LazyTwo();
        }

        return lazyTwo;
    }
}
