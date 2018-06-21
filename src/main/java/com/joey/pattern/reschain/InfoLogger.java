package com.joey.pattern.reschain;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/21.
 */
public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    void printMessage(String message) {
        System.out.println("info logger : " + message);
    }

}
