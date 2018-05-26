package com.joey.pattern.prototype;

import java.io.Serializable;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/26.
 */
public class Jingubang implements Serializable{

    public int width;
    public int height;

    public void bigger(){
        this.width = this.width*2;
        this.height = this.height*2;
    }

}
