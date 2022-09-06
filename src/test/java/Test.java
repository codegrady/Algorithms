import java.util.Arrays;

public class Test {
    
    public static void main(String[] args) {

        String  x = "Grady";
        System.out.println("x.hashCode() = " + x.hashCode());
        int h =x.hashCode() >>> 16;
        System.out.println("h = " + h);
        System.out.println(x.hashCode() ^ h);
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.numberOfLeadingZeros(-1));
        int n = -1 >>> Integer.numberOfLeadingZeros(-1);
        System.out.println("n = " + n);

        int xx = 123;
        System.out.println("xx <<< 8 = " + (xx << 8));
    }
}
