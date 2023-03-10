package questions.array_quadruplet;
/*
Array Quadruplet
Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers
(quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order.
 If such a quadruplet doesn’t exist, return an empty array.

Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you
encounter (considering the results are sorted).
Explain and code the most efficient solution possible, and analyze its time and space complexities.

Example:
input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                     # whose sum is 20. Notice that there
                     # are two other quadruplets whose sum is 20:
                     # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                     # asked to return the just one quadruplet (in an
                     # ascending order)
Constraints:
[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ 100
[input] integer s
[output] array.integer
 */

import java.io.*;
import java.util.*;

class Solution {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        // your code goes here
        if (arr.length < 4) {
            return new int[]{};
        }
        Arrays.sort(arr);
        int l, r;
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                l = j + 1;
                r = arr.length - 1;
                int sum = arr[i] + arr[j];
                while (l < r) {
                    if (sum + arr[l] + arr[r] == s) {
                        return new int[]{arr[i], arr[j], arr[l], arr[r]};
                    } else if (sum + arr[l] + arr[r] > s) {
                        r--;
                    } else if (sum + arr[l] + arr[r] < s) {
                        l++;
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        /*
         Expected output: 0, 4, 7, 9
        */
        System.out.println(Arrays.toString(findArrayQuadruplet(arr, 20)));
        //TC: O(NlogN) + O(N^3) = O(N^3)
        //SC: O(1)
    }
}