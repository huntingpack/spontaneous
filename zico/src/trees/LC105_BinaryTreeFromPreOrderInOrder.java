package trees;

import java.util.HashMap;
import java.util.Map;

public class LC105_BinaryTreeFromPreOrderInOrder {
    public static void main(String[] s){

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(null == preorder && null == inorder)return null;
        if(null == preorder || null==inorder)return null;
        if(preorder.length!=inorder.length)return null;

        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0; i<inorder.length;i++){
            index.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length-1, 0, index);
    }

    TreeNode helper(int[] preorder, int[] inorder, int in_start, int in_end, int pre_start, Map<Integer, Integer> index){
        if(pre_start > preorder.length-1 || in_start > in_end)return null;

        // int in_index = -1;
        // for(int i=in_start; i<=in_end; i++){
        //     if(inorder[i] == preorder[pre_start]){
        //         in_index = i;
        //         break;
        //     }
        // }
        // use a hashmap to speedup in_index lookup !!
        int in_index = index.get(preorder[pre_start]);

        // first elem of preorder traversal is always the root
        TreeNode root = new TreeNode(preorder[pre_start]);
        root.left = helper(preorder, inorder, in_start, in_index-1, pre_start+1, index);
        // root of subtree in preorder seq will be (size of left subtree) => inIndex - inStart + 1
        root.right = helper(preorder, inorder, in_index+1, in_end, pre_start + in_index - in_start + 1, index);
        return root;
    }

}
