package com.joey.pattern.reschain;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/21.
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    void printMessage(String message) {
        System.out.println("console logger : " + message);
    }
}
