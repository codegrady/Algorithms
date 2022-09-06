package leetcode;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer,Integer> keyIndexMap;
    private HashMap<Integer,Integer> indexKeyMap;
    private int size;

    public RandomizedSet() {
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }

    public boolean insert(int val) {
        if(!keyIndexMap.containsKey(val)){
            keyIndexMap.put(val,size);
            indexKeyMap.put(size++,val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(keyIndexMap.containsKey(val)){
            int deleteIndex = keyIndexMap.get(val);
            int lastIndex = --size;
            int lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.put(lastKey,deleteIndex);
            indexKeyMap.put(deleteIndex,lastKey);
            keyIndexMap.remove(val);
            indexKeyMap.remove(size);
            return true;
        }
        return false;
    }

    public int getRandom() {
        if(size == 0){
            return  -1;
        }
        int random = (int) Math.random() * size;
        return indexKeyMap.get(random);
    }
}
