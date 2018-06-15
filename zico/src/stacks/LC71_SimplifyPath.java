package stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/description/
 */
public class LC71_SimplifyPath {

    public static void main(String[] s){
        System.out.println(new LC71_SimplifyPath().simplifyPath("/abc/..."));
    }

    public String simplifyPath(String path){
        if(path == null || path.isEmpty())return "/";

        // when we encounter a '.', or empty str '' we simply skip
        Set<String> skip = new HashSet<>(Arrays.asList("","."));
        Stack<String> dirs = new Stack<>();
        String[] pathElems = path.split("/");
        for(String pathElem : pathElems){
            if(skip.contains(pathElem))continue;
            else if(pathElem.equals("..")){
                // if '..' then we pop
                if(!dirs.isEmpty()) {
                    dirs.pop();
                }
            }
            else {
                dirs.push(pathElem);
            }
        }

        StringBuilder sb = new StringBuilder("/");// start with the root
        // Stack is also a List so iterate in left to right order
        for(String dir : dirs){
            sb.append(dir).append("/");
        }
        // if len > 1 then at least one dir exists. Since we always append
        // a '/' we remove the last redundant one
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
