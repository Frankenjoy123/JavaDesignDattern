package com.joey.pattern.reschain2;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/6/29.
 */
public interface Invoker {

    /**
     *
     * @param invocation
     * @return Result
     */
    String invoke(String invocation);
}
