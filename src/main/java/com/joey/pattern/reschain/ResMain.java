package com.joey.pattern.reschain;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/21.
 */
public class ResMain {

    public static void main(String[] args) {


        AbstractLogger logger = getLogger();

        logger.log(AbstractLogger.info , " info hello ,world");

        logger.log(AbstractLogger.error , "error detail");


    }


    private static AbstractLogger getLogger(){
        ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.error);

        InfoLogger infoLogger = new InfoLogger(AbstractLogger.info);

        ConsoleLogger consoleLogger = new ConsoleLogger(AbstractLogger.info);

        errorLogger.setNextLogger(infoLogger);

        infoLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}


