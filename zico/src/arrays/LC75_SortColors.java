package arrays;

import java.util.Arrays;

public class LC75_SortColors {
    public static void main(String[] s){
        int[] nums = new int[]{0,0,1,1,1,2,2};
        nums = new int[]{0};
        nums = new int[]{2,0,2,1,1,0};
        new LC75_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums){
        if(nums==null || nums.length==0)return;

        int i0 = 0;//points to index where a 0 can be inserted
        int i2=nums.length-1; // points to index where a 2 can be inserted
        int current=0; // current index

        // move all 0s to the left and 2s to the right
        while(current<=i2){
            // if current is zero then move it to i0
            if(nums[current]==0){
                //swap current and i0
                // basically we are moving os to the left
                swap(nums, current, i0);
                //now move i0
                i0++;

                // always ensure current is between i0 and i2
                if(current <=i0) current = i0;

                // after swapping current could be pointing to 2 !
                // as we are not moving the current pointer the while loop
                // will ensure that 2 is taken care of !!
            }
            else {
                // check if it is 2 then move it to thr right
                if(nums[current] == 2){
                    // similar to above case move 2s to the right
                    swap(nums, current, i2);
                    i2--;
                }
                else{
                    current++;
                }
            }
        }
    }

    public void sortColors2Pass(int[] nums){
        int c0=0;
        int c1=0;
        int c2=0;
        for(int i : nums){
            if(i==0)c0++;
            else if(i==1)c1++;
            else if(i==2)c2++;
        }

        for(int i=0; i<nums.length;i++){
            if(i<c0)nums[i]=0;
            else if(i<c0+c1)nums[i]=1;
            else if(i<c0+c1+c2)nums[i]=2;
        }
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
