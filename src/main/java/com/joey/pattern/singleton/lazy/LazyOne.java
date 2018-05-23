package com.joey.pattern.singleton.lazy;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/22.
 */
public class LazyOne {

    private static LazyOne lazyOne = null;

    //缺点：会存在线程安全问题
    public static LazyOne getInstance(){

        if (lazyOne == null){
            lazyOne = new LazyOne();
        }

        return lazyOne;
    }
}
