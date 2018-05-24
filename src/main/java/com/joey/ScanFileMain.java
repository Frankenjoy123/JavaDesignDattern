package com.joey;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/24.
 */
public class ScanFileMain {

        private static List<String> stringList;

        public static void main(String[] args) {

            String path = "/Users/zhouxiaowu/IdeaProject-tongdun/stark/web/src/main/webapp/common";

            stringList = new ArrayList<String>();

            try {
                readDir(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            stringList = stringList.stream().distinct().collect(Collectors.toList());

            stringList.forEach(t -> {
                System.out.println(t);
            });

        }


    public static void readDir(String folder) throws IOException {
        File dir = new File(folder);
        // PrintWriter output = new PrintWriter(new FileWriter(new
        // File(outFile)));
        if (dir.isDirectory()) {

//            System.out.println("#Dir#" + dir.getName() + "\n");
//            output.write("#Dir#" + dir.getName() + "\n");
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                File tempFile = new File(dir, children[i]);
                if (tempFile.isDirectory())
                    readDir(tempFile.getPath());
                else if (tempFile.getName().endsWith(".vm")){
                    readTxt(tempFile);
                }
            }
        }
    }

    private static void readTxt(File tempFile) {


        //BufferedReader是可以按行读取文件
        try {
            FileInputStream inputStream = new FileInputStream(tempFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {
//                System.out.println(str);
                doWithStr(str);
            }



            //close
            inputStream.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // >中文< "中文"
        private static void doWithStr(String str){

            Pattern p = Pattern.compile("(\\s*[a-z A-Z 0-9 \\u4e00-\\u9fa5]*[\\u4e00-\\u9fa5]+[a-z A-Z 0-9 \\u4e00-\\u9fa5]*\\s*)");
            Matcher m = p.matcher(str);

            if (m.find()){
                stringList.add(m.group());
            }

//            int groupCount = m.groupCount();
//
////        boolean match = m.lookingAt();//true
//
//
//            for (int i=0 ; i<groupCount ; i++){
//                String s =m.group(i);
//                stringList.add(s);
//            }

//        System.out.println(match);

        }


}
