package com.joey.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/26.
 */
public class RegisterFactory {

    private static Map<String , Object> registerMap = new ConcurrentHashMap<>();



    public static Object getInstance(String className){


        if (className == null || className.length()==0){
            return null;
        }


        if (!registerMap.containsKey(className)){

            try {
                Class<?> clazz =Class.forName(className);
                Object object = clazz.newInstance();

                registerMap.put(className ,object);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }

        return registerMap.get(className);

    }

}
