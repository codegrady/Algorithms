import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Test {
    
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("abc");
        System.out.println(String.valueOf(sb).equals(String.valueOf(sb.reverse())));
        System.out.println(sb);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        Set<Long> set = new HashSet<>();
//        list.forEach(i->set.add(System.currentTimeMillis()));
//        System.out.println(set.size());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.nanoTime());

    }
}
