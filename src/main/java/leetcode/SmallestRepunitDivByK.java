package leetcode;

/**
 * 1015
 */
public class SmallestRepunitDivByK {

    public static void main(String[] args) {
        int k = 17;
        System.out.println(smallestRepunitDivByK(k));
    }

    public static int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0){
            return -1;
        }
        long n= 1L;
        while (n%k!=0){
            n=n*10+1;
        }
        return String.valueOf(n).length();
    }
}
