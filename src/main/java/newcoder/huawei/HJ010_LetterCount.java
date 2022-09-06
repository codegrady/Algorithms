package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HJ010_LetterCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        System.out.println(set.size());
    }
}
