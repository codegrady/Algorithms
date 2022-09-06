package other;

/**
 *  二位矩阵中只有0和1，每个1都可以上下左右的移动
 *  想让所有的1汇聚到一起(一个点) 开会
 *  请返回所有1移动的做小距离和
 *
 *  思路： -- 双指针
 *      分别找到会议点 最好的行 和 最好的列
 *      最优行的确定： 1行有8个1   17行有2个1，则确定17行为非最优行
 *      当确定 本行不是最优解之后，将本行的1向最优行方向移动，如：1行有8个，2行有9个，移动后 2行有17个1
 *      以此确定最优行；
 *      同理 得到最优列
 */

public class MeetingNum {

    public static int minTotalDistance(int[][] grid){
        int N = grid.length;//行数
        int M = grid[0].length;//列数
        int[] iOnes = new int[N];
        int[] jOnes = new int[M];
        for(int i = 0; i<N;i++){
            for (int j=0;j<M;j++){
                if(grid[i][j] == 1){
                    iOnes[i]++;
                    jOnes[j]++;
                }
            }
        }

        int total = 0;
        int i = 0, j = N -1;
        int iRest = 0, jRest = 0;
        while (i<j){
            if(iOnes[i]+iRest <= iOnes[j]+jRest){
                total += iOnes[i]+iRest;
                iRest += iOnes[i++];
            }else {
                total += iOnes[j]+iRest;
                iRest += iOnes[j--];
            }
        }
        i = 0; j = M-1;
        iRest = 0;jRest =0;

        while (i<j){
            if(jOnes[i]+iRest <= jOnes[j]+jRest){
                total +=jOnes[i];
                iRest += jOnes[i++];
            }else {
                total += jOnes[j];
                jRest += jOnes[j--];
            }
        }

        return  total;
    }

}
