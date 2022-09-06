package leetcode;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    // 每个数字 先和 3、8 比较 在和5比较
    public static String intToRoman(int num){
        String[][] arra =  {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        int x = 0;
        String s = "";
        while (num > 0){
            s = arra[x][num%10] + s;
            num /=10;
            x++;
        }
        return s;
    }
}
