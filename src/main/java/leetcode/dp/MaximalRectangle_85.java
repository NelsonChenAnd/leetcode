package leetcode.dp;

/**
 * Author: SJ
 * Date: 2019/1/23
 *
 * 难度等级：Hard
 * 解决方法：复杂点的DP 问题，需要额外使用的空间多一些
 * 开辟三个数组：
 * 1） left：存储矩形区域最左侧边界（包含）
 * 2） right：存储矩形区域最右侧边界（不包含）
 * 3） height：存储矩形区域的高度。
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) {
            return 0;
        }
        int rowNum = matrix.length, colNum = matrix[0].length;
        int height[] = new int[colNum];
        int left[] = new int[colNum];
        int right[] = new int[colNum];

        // 初始化right全是colNum
        for(int i=0; i<colNum; i++) {
            right[i] = colNum;
        }
        int ans = 0;
        for(int i=0; i<rowNum; i++) {
            int curLeft = 0, curRight = colNum;
            for(int j=0; j<colNum; j++) {
                if(matrix[i][j]=='1') {
                    height[j]+=1;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j]=0;
                    left[j]=0;
                    curLeft=j+1;
                }
            }
            for(int j=colNum-1; j>=0; j--) {
                if(matrix[i][j]=='1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = colNum;
                    curRight = j;
                }
            }
            for(int j=0; j<colNum; j++) {
                ans = Math.max((right[j]-left[j])*height[j], ans);
            }
        }
        return ans;
    }
}
