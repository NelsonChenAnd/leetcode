import junit.framework.TestCase;

import java.util.*;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-5-23
 */
public class Test extends TestCase {

    public void testArrayList() {

        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row = new LinkedList<>();
        row.add(1);
        row.add(2);
        row.add(3);
        row.add(4);
        row.add(5);

        int num = 3;
        int index=0;

        while(row.size()!=0) {

            for(int i=1; i<num; i++) {
                index = index % row.size();
                index++;
                if(index == row.size()) {
                    index=0;
                }
            }

            row.remove(index);
            System.out.println(row + "\t" + index);
        }
    }


    public void testString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello");
        buffer.reverse();
        System.out.println(buffer);
        char[] cs = buffer.toString().toCharArray();
        System.out.println(cs.length);
        for(char c: cs) {
            System.out.println("ccc=>" + c);
        }
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

    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        queue.add(1);
        queue.add(23);
        queue.add(22);
        while(!queue.isEmpty()) {
            int x = queue.remove();
            System.out.println(x);
        }
        System.out.println(queue);
    }


}
