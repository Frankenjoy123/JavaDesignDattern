package com.joey.pattern.reschain;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/21.
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    void printMessage(String message) {
        System.out.println("error logger : " + message);
    }
}
