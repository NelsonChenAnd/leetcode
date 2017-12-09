package leetcode.math;

/**
 * 功能描述：Implement pow(x, n).


 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 *
 * @Author SJ
 * @Date 2017-12-1
 */
public class Pow {
    public double myPow(double x, int n) {

        if(x==0&&n==0) {
            return Double.NaN;
        }

        if(n>=0) {
            return positivePow(x, n);
        } else {
            return 1/positivePow(x, -n);
        }
    }

    private double positivePow(double x, int n) {
        if(n==0) {
            return 1;
        } else if(n==1) {
            return x;
        } else if(n%2==0) {
            double temp = positivePow(x, n/2);
            return temp* temp;
        } else {
            double temp = positivePow(x, n/2);
            return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        pow.myPow(0.0,1);
    }
}
