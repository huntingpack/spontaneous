package trees;

/**
 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 */
public class LC99_RecoverBST {
    // maintain 3 vars
    TreeNode first,middle,last,prev;

    public static void main(String[] s){

    }


    // case 1: the swapped nodes are adjacent
    // case 2: the swapped nodes are not adjacent
    public void recoverTree(TreeNode root) {
        traverse(root);

        // case 1. the swapped pairs are not adj
        if(first !=null && last !=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // case 2. the swapped pairs are adj
        else if(first!=null && middle!=null){
            int temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }
        else{
            // the tree is already sorted !!!
        }
    }

    /**
     * Do in order traversal and update 3 vars
     * if root.val < prev.val it implies that we have encountered out of order pairs
     * if 'first' is empty then set it to prev and 'middle' to current.
     * @param root
     */
    void traverse(TreeNode root){
        if(root==null)return;

        traverse(root.left);

        if(null != prev){
            if(root.val < prev.val){
                if(null == first){
                    first = prev;
                    middle = root;
                }
                else{
                    last = root;
                }
            }
        }
        prev = root;

        traverse(root.right);
    }


}
