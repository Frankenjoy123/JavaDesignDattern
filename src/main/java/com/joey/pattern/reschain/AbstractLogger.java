package com.joey.pattern.reschain;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/21.
 */
public abstract class AbstractLogger {

    public static final int debug =0;

    public static final int info = 1;

    public static final int error =2;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(int level , String message){

        if (this.level >= level){
            printMessage(message);
        }

        if (nextLogger != null){
            nextLogger.log(level , message);
        }

    }

    abstract void printMessage(String message);

}
