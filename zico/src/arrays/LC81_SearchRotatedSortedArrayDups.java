package arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218/My-8ms-C++-solution-(o(logn)-on-average-o(n)-worst-case)
 */
public class LC81_SearchRotatedSortedArrayDups {
    public static void main(String[] s){
        int[] nums = new int[]{2,5,6,0,0,1,2};
        nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(new LC81_SearchRotatedSortedArrayDups().search(nums, 3));
    }

    public boolean search(int[] nums, int target){
        if(nums==null || nums.length==0)return false;

        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)return true;

            // check if left side is sorted
            if(nums[l] < nums[mid]){
                // check if target lies in the left side range
                if(nums[l]<=target && target < nums[mid]){
                    r=mid-1;
                }
                else{
                    l = mid+1;
                }
            } // is right side sorted ?
            else if(nums[mid] < nums[r]){
                // does target lie in that range ?
                if(nums[mid] < target && target <= nums[r]){
                    l=mid+1;
                }
                else{
                    r= mid-1;
                }
            }
            else{
                // if equal move l and r closer to mid
                if(nums[mid] == nums[l])l++;
                if(nums[mid] == nums[r])r--;
            }
        }
        return false;
    }

}
