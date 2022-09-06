package newcoder.huawei;

import java.io.*;

/**
 * 识别有效的IP地址和掩码并进行分类统计

请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

所有的IP地址划分为 A,B,C,D,E五类

A类地址从1.0.0.0到126.255.255.255;

B类地址从128.0.0.0到191.255.255.255;

C类地址从192.0.0.0到223.255.255.255;

D类地址从224.0.0.0到239.255.255.255；

E类地址从240.0.0.0到255.255.255.255


私网IP范围是：

从10.0.0.0到10.255.255.255

从172.16.0.0到172.31.255.255

从192.168.0.0到192.168.255.255


子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
（注意二进制下全是1或者全是0均为非法子网掩码）

注意：
1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
2. 私有IP地址和A,B,C,D,E类地址是不冲突的

输入描述：
多行字符串。每行一个IP地址和掩码，用~隔开。
输出描述：
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。

=================================
示例1
输入：
    10.70.44.68~255.254.255.0
    1.0.0.1~255.0.0.0
    192.168.0.2~255.255.255.0
    19..0.~255.255.255.0
输出：
    1 0 1 0 0 2 1
说明：
    10.70.44.68~255.254.255.0的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
    1.0.0.1~255.0.0.0是无误的A类地址；
    192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
    所以最终的结果为1 0 1 0 0 2 1        
示例2
输入：
    0.201.56.50~255.255.111.255
    127.201.56.50~255.255.111.255
输出：
   0 0 0 0 0 0 0
说明：
    类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略     
 */
public class HJ018_IPClassification {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = 0,B = 0, C = 0, D = 0, E = 0,illegal = 0, pri = 0; 
        String str = null;
        while((str = br.readLine()) != null){
            if(str.length()<1){
                break;
            }
            String[] strs = str.split("~");
            String ip = strs[0],mask = strs[1];
            String[] ipParts = ip.split("\\.");
            if(ip.startsWith("0") || ip.startsWith("127")){
                continue;
            }
            if(isIllegalIpOrMask(ipParts, mask)){
                illegal++;
                continue;
            }
            
            int ipHeader = Integer.parseInt(ipParts[0]);

            if(ipHeader<=126){
                A++;
            }else if(ipHeader<=191){
                B++;
            }else if(ipHeader<=223){
                C++;
            }else if(ipHeader<=239){
                D++;
            }else if(ipHeader<=255){
                E++;
            }
            
            if(isPrivateIp(ipParts)){
                pri++;
            }

        }
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + illegal + " " + pri);
    }

    private static boolean isIllegalIpOrMask(String[] ipParts,String mask){
    
        // IP 验证
        if(ipParts.length != 4){
            return true;
        }
        for(String str : ipParts){
            if(str.length()<1 || Integer.parseInt(str)>255){
                return true;
            }
        }
        //掩码 验证
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(maskArr[2]) + toBinary(maskArr[3]);
        if (!maskBinary.matches("[1]{1,}[0]{1,}")) {
            return true;
        }
        return false;
    }

    private static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    private static boolean isPrivateIp(String[] ipParts){
        int x = Integer.parseInt(ipParts[1]);
        
        return ipParts[0].equals("10") || (ipParts[0].equals("192") && ipParts[1].equals("168") || (ipParts[0].equals("172") && 16<=x && x<=31));
    }
     
}
