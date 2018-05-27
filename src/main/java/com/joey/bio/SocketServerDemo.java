package com.joey.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/27.
 */
public class SocketServerDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket server  = new ServerSocket(7080);

        Socket socket = server.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        System.out.println(line);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("server do with client msg : " + line);

//        while (true);

    }
}
