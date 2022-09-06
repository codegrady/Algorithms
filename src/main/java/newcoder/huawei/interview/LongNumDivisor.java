package newcoder.huawei.interview;

/**
 * 参数number 是一个仅由数字0-9组成的合法的整数，长度可能很长，但是小于1024*1024位；
 * 参数 divisor 为长度为一位的整数，求number代表的数除以divisor代表的数的实现；
 * 如果不能整除，请保留2位小数，且能实现四舍五入；
 */
public class LongNumDivisor {

    public static void main(String[] args) {
        String number = "606";
        System.out.println("number.length() = " + number.length());
        String divisor = "6";
        String ret = getResult(number, divisor);
        System.out.println("ret.length() = " + ret.length());
        System.out.println(ret);
    }

    static String getResult(String number, String divisor){
        int d = Integer.parseInt(divisor);
        if(d == 0){
            return null;
        }

        int num = 0; //上次除后的余数
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<number.length();i++){
            int cur = number.charAt(i) - '0';
            int r = (cur+num*10)/d;
            sb.append(r);
            num  = (cur+num*10)%d;
        }
        if(num !=0){
            num *=100;
            int x = num / d;
            if((num%d)/d > 0.4){
                x+=1;
            }
            sb.append(".").append(x);
        }
        String s = sb.toString();
        if(s.startsWith("0")){
            s = s.substring(1);
        }
        return s;

    }
}
