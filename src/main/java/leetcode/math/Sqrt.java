package leetcode.math;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * 实现 int 类型的开方，计算并返回 x 的平方根。
 * x 是非负 int 类型
 *
 * @Link https://leetcode.com/problems/sqrtx/description/
 *
 * 解题：两种方案，第二种比较次数可能会减少。
 * 1. 只是简单从1->x/2 计算平方判断大小。
 * 2. 看了topics 有 Binary Search，说明可以利用二叉查找。
 * 小trick：一定要记住 对于数字int 的乘积可能会比Integer.MAX_VALUE还要大，导致溢出。所以可以用除法来做优化。
 */

public class Sqrt {

    /**
     * 直接从1 -> x/2 进行遍历，比较判断大小。
     * @param  int x             [description]
     * @return     [description]
     */
    public int mySqrt(int x) {

        if(x==0||x==1) {
            return x;
        }
        for(int i=1; i<=x/2; i++) {
            if(i<=x/i && (i+1)>x/(i+1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 采用二分查找法计算平方根。
     * 测试用例=》2147395599
     * @param  int x             [description]
     * @return     [description]
     */
    public int mySqrtBinarySearch(int x) {
        if(x==0||x==1) {
            return x;
        }
        int min=1, max=x;
        while(min<=max) {
            int mid=(min+max)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)) {
                return mid;
            } else if(mid>x/mid) {
                max=mid-1;
            } else {
                min=mid+1;
            }
        }
        return -1;
    }
}
