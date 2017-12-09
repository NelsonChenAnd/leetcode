package leetcode.string;

import java.util.Stack;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2017-12-7
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<String>();
        String[] splits = path.split("/", -1);
        System.out.println(path+"\t"+splits.length);

        for(int i=0; i< splits.length; i++) {
            System.out.println(i+"\t"+splits[i]);
            if(splits[i].equals(""))
                continue;
            //System.out.println(stack.size());
            if(splits[i].equals(".")) {
                continue;
            } else if(splits[i].equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(splits[i]);
            }
        }
        System.out.println("stack "+stack);
        StringBuffer buf =new StringBuffer();
        while(!stack.isEmpty()) {
            buf.insert(0, stack.pop());
            buf.insert(0, "/");
        }

//        buf = buf.reverse();

        if(buf.length()==0) {
            buf.append('/');
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String path = "/";
        System.out.println(simplifyPath(path));
    }
}
