package com.joey.pattern.singleton.test;

import com.joey.pattern.Constants;
import com.joey.pattern.singleton.hungry.HungryEntity;
import com.joey.pattern.singleton.lazy.LazyOne;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/22.
 */
public class LazyOneTest {


    //懒汉式存在线程不安全
    public static void main(String[] args) {


        int num = Constants.THREAD_NUM;

        CountDownLatch countDownLatch = new CountDownLatch(num);

        CopyOnWriteArrayList<LazyOne> list = new CopyOnWriteArrayList<>();


        long startTime = System.currentTimeMillis();

        for (int i=0; i<num ;i++){
            Thread thread = new Thread("mythread"+ String.valueOf(i)){
                @Override
                public void run() {

                    LazyOne entity = LazyOne.getInstance();
                    list.add(entity);
                    countDownLatch.countDown();

                }
            };
            thread.start();
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endTime = System.currentTimeMillis();

        System.out.println("lazy one 耗时：" + (endTime - startTime) +"ms");

        System.out.println(list.stream().collect(Collectors.groupingBy(LazyOne::toString , Collectors.counting())));

    }

}
