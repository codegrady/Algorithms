package newcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 字符串排序
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 */
public class HJ014_StrSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] strs = new String[count];
        for(int i = 0;i<count;i++){
            strs[i] = br.readLine();
        }
        br.close();

        Arrays.sort(strs);
        for(int i = 0;i<count;i++){
           System.out.println(strs[i]);
        }
        
    }
}
