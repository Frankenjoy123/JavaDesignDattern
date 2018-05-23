package com.joey.pattern.singleton.test;

import com.joey.pattern.Constants;
import com.joey.pattern.singleton.lazy.LazyOne;
import com.joey.pattern.singleton.lazy.LazyTwo;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/22.
 */
public class LazyTwoTest {


    //懒汉式存在线程不安全
    public static void main(String[] args) {


        int num = Constants.THREAD_NUM;

        CountDownLatch countDownLatch = new CountDownLatch(num);

        CopyOnWriteArrayList list = new CopyOnWriteArrayList();


        long startTime = System.currentTimeMillis();

        for (int i=0; i<num ;i++){
            Thread thread = new Thread("mythread"+ String.valueOf(i)){
                @Override
                public void run() {

                    LazyTwo entity = LazyTwo.getInstance();
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

        System.out.println("lazy two 耗时：" + (endTime - startTime) +"ms");

        System.out.println(list.stream().collect(Collectors.groupingBy(LazyTwo::toString , Collectors.counting())));

    }

}
