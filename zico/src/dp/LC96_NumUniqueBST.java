package dp;

/**
 * Created by spuvvada on 18/06/18.
 */
public class LC96_NumUniqueBST {

    public static void main(String[] s){

    }

    /**
     * nodes are represented as a seq from 1...n
     * return num of unique BST that can be formed
     * @param n
     * @return
     */
    public int numTrees(int n) {

        //T[i] = num of BSTs that can be formed by a seq of length 'i'
        int[] T = new int[n+1];

        // treat each node as a root and recurse on left and on right
        // Ex: 1,2,3,4,5
        // if '3' is root then:
        //      empty on left and 2 nodes on right (T[0]*T[2])
        //      1 on left and 1 on right (T[1]*T[1])
        //      2 on left and empty on right (T[2]*T[0]

        //base case
        T[0]=1;//empty nodes - we can form only 1 tree
        T[1]=1;// 1 node we can form only one tree

        for(int root=2;root<=n;root++){
            for(int subtreelen = 0; subtreelen<root;subtreelen++){
                T[root]+= T[subtreelen] * T[root-subtreelen-1];
            }
        }

        return T[n];
    }
}
