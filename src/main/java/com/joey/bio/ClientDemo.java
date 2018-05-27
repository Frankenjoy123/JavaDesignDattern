package com.joey.bio;

import java.io.*;
import java.net.Socket;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/27.
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1" , 7080);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, world");
//        bufferedWriter.flush();


        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        System.out.println(new String(bytes,0,bytes.length));

    }
}
