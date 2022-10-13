package leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class MatrixSetZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>(),cols = new HashSet<>();

        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if(rows.contains(i)){
                matrix[i] = new int[N];
                continue;
            }
            for (int j = 0; j < N; j++) {
                if(cols.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
