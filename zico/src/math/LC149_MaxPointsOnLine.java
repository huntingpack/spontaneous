package math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/count-maximum-points-on-same-line/
 */

public class LC149_MaxPointsOnLine {

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] s){
        System.out.println(new LC149_MaxPointsOnLine().maxPoints(new Point[]{new Point(1,1), new Point(2,2), new Point(3,3)}));
    }



    public int maxPoints(Point[] points){
        // for each pair of points track the slope
        // use a map to record all pairs that have the same slope
        // slope = y2-y1/x2-x1. This could cause precision issues so we simply
        // store ydiff/gcd(ydiff,xdiff) + "-" + xdiff/gcd(ydiff,xdiff) as the key into a map


        if(points == null || points.length<2)return points.length;

        int dups;
        int sameVerticalLine;
        Map<String,Integer> slope2Count = new HashMap<>();

        int currentMax;
        int globalMax = Integer.MIN_VALUE;


        for(int i=0; i<points.length;i++){

            // calculate duplicate points i.e same (x,y) for each point[i]
            dups = 0;
            // also calculate all pairs with same slope for each point[i]
            slope2Count.clear();
            sameVerticalLine=0;
            currentMax = 0;

            for(int j=i+1; j<points.length; j++){

                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    dups++;
                }
                else if(points[i].x == points[j].x){
                    sameVerticalLine++;
                }
                else {

                    int ydiff = points[i].y - points[j].y;
                    int xdiff = points[i].x - points[j].x;

                    // slope is ydiff/xdiff but due to precision issues during div we simply use them as is

                    int _gcd = gcd(ydiff, xdiff);
                    ydiff = ydiff / _gcd;
                    xdiff = xdiff / _gcd;

                    String key = "" + ydiff + "-" + xdiff;
                    slope2Count.put(key, slope2Count.getOrDefault(key, 0) + 1);
                    // currentMax => pairs with same slope
                    currentMax = Math.max(currentMax, slope2Count.get(key));
                }

                currentMax = Math.max(currentMax, sameVerticalLine);
            }

            // currentMax corresponds to how many pairs have the same slope
            // dups are basically the same points
            // +1 as we want to count points
            globalMax = Math.max(globalMax, currentMax + dups + 1);
        }
        return globalMax;
    }

    int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
}
