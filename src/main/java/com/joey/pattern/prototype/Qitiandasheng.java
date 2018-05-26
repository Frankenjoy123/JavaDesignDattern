package com.joey.pattern.prototype;

import java.io.*;
import java.util.Date;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/26.
 */
public class Qitiandasheng extends Monkey implements Cloneable , Serializable{


    public Jingubang jingubang;

    public Qitiandasheng() {
        this.birth = new Date();
        this.jingubang = new Jingubang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //默认clone是浅复制
//        return super.clone();

        //深复制方法
        return this.deepClone();
    }


    private Object deepClone(){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);


            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
