package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        List<List<String>> ans = queens.solveNQueens(4);
        System.out.println(ans);
    }

    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {

        if(n<=0) {
            return ans;
        }

        int[] flag = new int[n];
        char[][] matrix = new char[n][n];
        for(int i=0; i<matrix.length; i++) {
            flag[i] = -1;
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = '.';
            }
        }


        backTracing(0, n, matrix, flag);
        return ans;
    }

    /**
     * 从start 行开始，向下进行BackTracing，flag 数组存储第start行存储的是第i列
     * @param start 棋盘的当前行
     * @param n 皇后个数
     * @param matrix 棋盘表示
     * @param flag 存储的列下标。
     */
    public void backTracing(int start, int n, char[][] matrix, int[] flag) {

        if(start==n) {
            List<String> list = new ArrayList<String>();
            for(int i=0; i<n; i++) {
                list.add(new String(matrix[i]));
            }
            ans.add(list);
            return;
        }

        for(int i=0; i<n; i++) {
            if(flag[start]==-1) {
                boolean tag = false;
                for(int j=0; j<start; j++) {
                    if((flag[j]!=-1 && (j-start==i-flag[j] || start-j==i-flag[j])) || flag[j]==i) { // 去掉不符合规则的条件
                        tag = true;
                        break;
                    }

                }
                if(tag == true) {
                    continue;
                }
                flag[start] = i;
                matrix[start][i] = 'Q';
//                System.out.println(start + "\t" + Arrays.toString(matrix[start]) + "\t" + Arrays.toString(flag));
                backTracing(start+1, n, matrix, flag);
                matrix[start][i] = '.';
                flag[start] = -1;
            }

        }
    }
}
