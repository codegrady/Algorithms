import java.util.*;

public class Test {
    
    public static void main(String[] args) {
        System.out.println(((Math.pow(10, 9) + 7) > Integer.MAX_VALUE));

        int a = 46,b=20;
        System.out.println((a^b) + ((a&b)<<1));
    }
}
