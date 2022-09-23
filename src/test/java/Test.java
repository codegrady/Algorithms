import java.util.*;

public class Test {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Set<Long> set = new HashSet<>();
        list.forEach(i->set.add(System.currentTimeMillis()));
        System.out.println(set.size());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
    }
}
