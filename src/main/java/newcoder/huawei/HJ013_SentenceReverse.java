package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 句子逆序
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class HJ013_SentenceReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        String[] words = str.split(" ");

        if(words.length == 1){
            System.out.println(words);
        }else{
            for(int i = words.length -1;i >=0; i--){
                System.out.print(words[i]+" ");
            }
        }

    }
}
