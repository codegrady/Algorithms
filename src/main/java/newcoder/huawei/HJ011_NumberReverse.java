package newcoder.huawei;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class HJ011_NumberReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        br.close();
        System.out.println("=========");
        StringBuilder sb = new StringBuilder("");
        // sb.reverse();
        // System.out.println(sb.toString());
        System.out.println(str.length());

        for(int i = str.length(); i >=0 ; i--){
            char c = str.charAt(i);
            sb.append(c);
        }

        sb.append('d');
        System.out.println(sb.toString());
        System.out.println("00000000000");
    }
}
