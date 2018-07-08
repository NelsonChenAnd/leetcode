import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-5-23
 */
public class Test extends TestCase {

    public void testArrayList() {

        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();

        for(int i=0;i<5;i++) {
        }
    }


    public void testString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello");
        buffer.reverse();
        System.out.println(buffer.substring(20));
    }


    public void testIterator() {
        Iterator<Integer> itr = new ArrayList<Integer>().iterator();

    }

    public int testDuplicateNum(int nums[]) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }
        return sum-(nums.length)*(nums.length-1)/2;
    }

}
