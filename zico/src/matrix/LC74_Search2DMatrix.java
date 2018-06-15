package matrix;

/**
 *
 * Explanation:https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
 */
public class LC74_Search2DMatrix {
    public static void main(String[] s){

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // Each row is sorted and first elem of each row is > last elem
        // of previous row => row by row is sorted

        // treat the whole matrix as a sorted list and simply do binary search
        // let m = matrix.length (# rows) and n = matrix[0].length (# cols)
        // each index can be represented as i = r*n + c
        // also from and index 'i' r=i/n, c= i%n

        //indices range from 0 to (m-1)*n + n-1

        if(matrix==null || matrix.length==0)return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = (m-1)*n + (n-1);

        while(l<=r){
            int mid = l + (r-l)/2;
            int x = mid/n;
            int y = mid%n;

            if(matrix[x][y] == target){
                return true;
            }
            if(matrix[x][y] < target){
                l = mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}
