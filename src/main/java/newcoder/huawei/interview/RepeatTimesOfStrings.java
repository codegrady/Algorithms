package newcoder.huawei.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：字符串dataList链表中有很多长度不定的字符串(每个字符串都是有效的)，
 *     且在链表中的顺序没有规律；
 *     现在需要找出存在重复次数最多的字符串并返回，
 *     如果最大的重复次数存在多个字符串，
 *     则返回任意一个就可以，没有重复的则返回null；
 */
public class RepeatTimesOfStrings {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ababababababa");
        list.add("c");
        list.add("c");
        list.add("babbdfdsauf");

        System.out.println(getRepeatIndex(list));
    }

    static String getRepeatIndex(List<String> dataList){
        // 请补充函数的实现代码

        int max = 1;
        String maxStr = null;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<dataList.size();i++){
            String s = dataList.get(i);
            if(map.containsKey(s)){
                int c = map.get(s)+1;
                map.put(s, c);
                if(c>max){
                    maxStr = s;
                }
            }else{
                map.put(s, 1);
            }
        }
        return maxStr;
    }
}
