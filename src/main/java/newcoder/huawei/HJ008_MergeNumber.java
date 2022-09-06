package newcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


public class HJ008_MergeNumber {
    public static void main(String[] args) throws Exception{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int count = (int)st.nval;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0 ; i < count;i++){
            st.nextToken();
            int k = (int)st.nval;
            st.nextToken();
            int v = (int)st.nval;
            if(map.containsKey(k)){
                map.put(k, map.get(k)+v);
            }else{
                map.put(k, v);
            }
        }
        
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}
