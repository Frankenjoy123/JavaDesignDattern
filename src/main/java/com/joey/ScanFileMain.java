package com.joey;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/24.
 */
public class ScanFileMain {

        private static List<String> stringList = new ArrayList<>();

        public static void main(String[] args) {

//            String sourceFilePath = "/Users/zhouxiaowu/IdeaProject-tongdun/stark翻译target/后端/biz-service.txt";
            String path = "/Users/zhouxiaowu/IdeaProject-tongdun/stark/web/src/main/resources/static";


//            String sourceFilePath = "/Users/zhouxiaowu/IdeaProject-tongdun/stark翻译target/后端/biz-common.txt";
//            String path = "/Users/zhouxiaowu/IdeaProject-tongdun/stark/biz/common/src/main/java/cn/fraudmetrix/forseti/biz/common";

//            String sourceFilePath = "/Users/zhouxiaowu/IdeaProject-tongdun/stark翻译target/后端/dal-mysql.txt";
//            String path = "/Users/zhouxiaowu/IdeaProject-tongdun/stark/dal/mysql/src/main/java/cn/fraudmetrix/forseti/dal";


            String sourceFilePath = "/Users/zhouxiaowu/IdeaProject-tongdun/stark翻译target/后端/web-src-java.txt";
//            String path = "/Users/zhouxiaowu/IdeaProject-tongdun/stark/web/src/main/java/cn/fraudmetrix/forseti/web";

            Map<String , String> cnMap = new HashMap<>();
            Map<String , String> engMap = new HashMap<>();

            readFileToMap(sourceFilePath , cnMap , engMap);


            try {
                doWithDir(path , cnMap , engMap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    private static void readFileToMap(String sourceFilePath, Map<String, String> cnMap, Map<String, String> engMap) {
        File tempFile = new File(sourceFilePath);

        //BufferedReader是可以按行读取文件
        try {
            FileInputStream inputStream = new FileInputStream(tempFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {

                str = str.trim();

                if (str.length()>0){

                    String[] arr = str.split(":");

                    if (arr != null && arr.length>1){
                        String key = arr[0];
                        String value = arr[1].trim();

                        if (key.startsWith("zh")){
                            cnMap.put(key , value);
                        }else {
                            engMap.put(key , value);
                        }
                    }

                }

            }

            //close
            inputStream.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void doWithDir(String folder , Map<String , String> cnMap , Map<String , String> engMap) throws IOException {
        File dir = new File(folder);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                File tempFile = new File(dir, children[i]);
                if (tempFile.isDirectory())
                    doWithDir(tempFile.getPath() , cnMap , engMap);
                else{
                    replaceFileWithMap(tempFile , cnMap , engMap);
                }
            }
        }
    }

    private static void replaceFileWithMap(File tempFile, Map<String, String> cnMap, Map<String, String> engMap) {

            try {

                FileReader in = new FileReader(tempFile);

                BufferedReader bufIn = new BufferedReader(in);

                // 内存流, 作为临时流
                CharArrayWriter  tempStream = new CharArrayWriter();

                // 替换
                String line = null;

                while ( (line = bufIn.readLine()) != null) {
                    // 替换每行中, 符合条件的字符串
                    line = getLineFromMap(line , cnMap , engMap);

                    // 将该行写入内存
                    tempStream.write(line);
                    // 添加换行符
                    tempStream.append(System.getProperty("line.separator"));
                }

                // 关闭 输入流
                bufIn.close();

                System.out.println(tempStream.toCharArray());

                // 将内存中的流 写入 文件
                FileWriter out = new FileWriter(tempFile);
                tempStream.writeTo(out);
                out.close();


            }catch (Exception e){
                e.printStackTrace();
            }

    }

    private static String getLineFromMap(String line, Map<String, String> cnMap, Map<String, String> engMap) {

            boolean existKey = false;

            String rightEngKey = "";

            String rightCnKey = "";

            int strLen =0;

            for (Map.Entry<String , String> entry : cnMap.entrySet()) {

                String cnStr = entry.getValue();

                if (cnStr == null || cnStr.length() == 0) {
                    continue;
                }


                if (line.contains(cnStr)) {

                    String cnKey = entry.getKey();

                    String enKey = "en-" + cnKey.split("-")[1];

                    existKey = true;

                    if (cnKey.length() > strLen){
                        rightCnKey = cnKey;
                        rightEngKey = enKey;
                    }

                }

            }



             if (existKey){
                 String cnStr = cnMap.get(rightCnKey);

                 String enStr = engMap.get(rightEngKey);

                 line = line.replace(cnStr, enStr);
            }

            return line;
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
