package com.joey.pattern.factory.simplefactory;

import com.joey.pattern.factory.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/21.
 */
public class SimpleFactory {


    //简单工程，什么三无产品都能生产
    public Milk getMilk(String name){

        if (name.equals("蒙牛")){
            return new MengniuMilk();
        }else if (name.equals("伊利")){
            return new YiLiMilk();
        }else if (name.equals("特仑苏")){
            return new TelunsuMilk();
        }else if (name.equals("光明")){
            return new GuangmingMilk();
        }

        return null;
    }
}
