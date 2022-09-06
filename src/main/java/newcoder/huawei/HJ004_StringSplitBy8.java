package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HJ004_StringSplitBy8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        int length = str.length();
        int loop = length/8;
        int remainder = length % 8;
        while(loop>0){
            System.out.println(str.substring(0, 8));
            str = str.substring(8);
            loop --;
        }
        if(remainder>0){
            StringBuffer sb = new StringBuffer(str);
            for(int i = 0; i< 8 - remainder;i++){
                sb.append("0");
            }
            System.out.println(sb.toString());
        }
    }
}
