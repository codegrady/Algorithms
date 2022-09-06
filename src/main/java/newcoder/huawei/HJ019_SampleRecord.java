package newcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 简单错误记录
 * 描述
    开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理：
    1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
    最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
    2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
    3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
    4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
输入描述：
    每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

输出描述：
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 */
public class HJ019_SampleRecord {
    public static void main(String[] arge) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while((str = br.readLine()) != null){
            if(str.length()<1){
                break;
            }
            String[] strs = str.split(" ");
            // int rowNum = Integer.parseInt();
            String[] pathArra = strs[0].split("\\\\");
            String fileName = pathArra[pathArra.length - 1];

            fileName = fileName.length()>16? fileName.substring(fileName.length() - 16):fileName;
            String key = fileName+" "+strs[1];

            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        int count = 0;
        for (String key:map.keySet()){
            count++;
            if(count>(map.size()-8)){
                System.out.println(key+" "+map.get(key));
            }
        }
        
    }
}
