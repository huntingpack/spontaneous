package trees;

public class LC98_ValidateBST {
    public static void main(String[] s){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        System.out.println(new LC98_ValidateBST().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean helper(TreeNode root, int min, int max){
        if(root == null)return true;// empty root is a valid BST

        if(root.val <= min || root.val >= max)return false; // all vals must b strictly > min and < max

        // now check subtrees
        // for left subtree all vals must b strictly < root.val and similarly for
        // right subtrees all vals must b strictly > root.val
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
