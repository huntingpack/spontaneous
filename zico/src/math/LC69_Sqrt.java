package math;

/**
 * Created by spuvvada on 14/06/18.
 */
public class LC69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        if(x<0)return -1;

        int left = 1, right = x/2;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public static void main(String[] s){
        System.out.println(new LC69_Sqrt().mySqrt(110));
    }
}
