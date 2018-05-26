package com.joey.pattern.prototype;

import java.util.Objects;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/26.
 */
public class Test {

    public static void main(String[] args) {
        Qitiandasheng q1 = new Qitiandasheng();

        q1.height=100;
        q1.weight = 200;


        try {
            Qitiandasheng q2 = (Qitiandasheng) q1.clone();

            System.out.println(q1);
            System.out.println(q2);

            System.out.println(q1.jingubang);

            System.out.println(q2.jingubang);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
