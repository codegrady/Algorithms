package newcoder.huawei;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
            String[] arra = br.readLine().split(" ");
            System.out.println(Integer.parseInt(arra[0])+Integer.parseInt(arra[1]));
        }
    }
}