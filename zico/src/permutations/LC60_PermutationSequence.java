package permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * Explanation:https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
 */
public class LC60_PermutationSequence {

    public static void main(String[] s){
        System.out.println(new LC60_PermutationSequence().getPermutation(4,9));
    }

    public String getPermutation(int n, int k) {
        if(n<0 || k<1)return "";

        // also k should be <=n! && >=1

        StringBuilder sb = new StringBuilder();

        // to store nums from 1...n and remove them
        List<Integer> nums = new LinkedList<>();
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1;i<=n;i++){
            factorial[i] = i * factorial[i-1];
            nums.add(i);
        }

        k--;// since everything is zero index

        for(int i=1;i<=n;i++){
            int index = k/factorial[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k - (index*factorial[n-i]);
        }

        return sb.toString();
    }
}
