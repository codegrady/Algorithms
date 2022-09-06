package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 坐标移动
 */
public class HJ017_CoordinateMovement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine().trim();
        reader.close();
        String[] strs = str.split(";");
        Map<String,Integer> map = new HashMap<>();
        map.put("x", 0);
        map.put("y", 0);
        for(int i=0;i<strs.length;i++){
            move(map,strs[i]);
        }
        System.out.println(map.get("x")+","+map.get("y"));
    }

    private static void move(Map<String,Integer> map,String str){
        if(str.length()<2){
            return;
        }
        String dirction = str.substring(0, 1);
        int distance = 0;
        try{
            distance = Integer.parseInt(str.substring(1));
        }catch(Exception e){
            return;
        }
        
        switch(dirction){
            case "A":
                map.put("x",map.get("x") - distance);
                break;
            case "S":
                map.put("y",map.get("y") - distance);
                break;
            case "D":
                map.put("x",map.get("x") + distance);
                break;
            case "W":
                map.put("y",map.get("y") + distance);
                break;
            default:
                return;
        }
    }

}
