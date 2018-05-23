package com.joey.pattern.singleton.lazy;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/23.
 */


//懒汉式单例
//特点：在外部类被调用的时候内部类才会被加载
//内部类一定是要在方法调用之前初始化
//巧妙地避免了线程安全问题

//外部类在调用之前，会先初始化内部类


//这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
//完美地屏蔽了这两个缺点
//史上最牛B的单例模式的实现方式

public class LazyThree {

    private boolean initialized = false;

    private LazyThree() {

        synchronized (LazyThree.class){

            if (!initialized){
                initialized = !initialized;
            }else {
                throw new RuntimeException("单例被侵犯");
            }


        }
    }


    public static LazyThree getInstance(){

        return LazyThreeHolder.LAZY;
    }


    //默认不加载
    private static class LazyThreeHolder{
         private static final LazyThree LAZY = new LazyThree();
    }

}
