package questions.number_of_paths;

/*
Number of Paths
You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid.
The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n, the size of the
 grid’s axes, write a function numOfPathsToDest that returns the number of the possible paths the driverless car can take.

For convenience, let’s represent every square in the grid as a pair (i,j). The first coordinate in the
pair denotes the east-to-west axis, and the second coordinate denotes the south-to-north axis.
The initial state of the car is (0,0), and the destination is (n-1,n-1).

The car must abide by the following two rules: it cannot cross the diagonal border. In other words, in every step the
position (i,j) needs to maintain i >= j. See the illustration above for n = 5. In every step, it may go one square
North (up), or one square East (right), but not both. E.g. if the car is at (3,1), it may go to (3,2) or (4,1).

Explain the correctness of your function, and analyze its time and space complexities.

Example:

input:  n = 4

output: 5 # since there are five possibilities:
          # “EEENNN”, “EENENN”, “ENEENN”, “ENENEN”, “EENNEN”,
          # where the 'E' character stands for moving one step
          # East, and the 'N' character stands for moving one step
          # North (so, for instance, the path sequence “EEENNN”
          # stands for the following steps that the car took:
          # East, East, East, North, North, North)

Constraints:
[time limit] 5000ms
[input] integer n
1 ≤ n ≤ 100
[output] integer
 */

class Solution {
    static int cnt;
    static int numOfPathsToDest(int n) {
        // your code goes here
        cnt = 0;
        helper(0, 0, n);
        return cnt;
    }

    static void helper(int row, int col, int n) {
        if (!isValid(row, col, n)) return;
        if (row == n - 1 && col == n - 1) {
            cnt++;
        }
        // up
        helper(row + 1, col, n);
        // right
        helper(row, col + 1, n);
    }

    static boolean isValid(int row, int col, int n) {
    /*
       0 is valid point
     2 110
     1 100
   r 0 000
       012
       c

      not valid point
       r,c
      (1,0), (2, 0), (2,1)
    */
        if (n < col || n < row) return false;
        if (row == col) return true;
        return row > col ? false : true;
    }

    static int numOfPathsToDestDp(int n) {
        // your code goes here
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 4;
        /*Expected output : 5 DP approach*/
        System.out.println(numOfPathsToDestDp(n));
        int n2 = 6;
        /*Expected output : 42 DFS approach*/
        System.out.println(numOfPathsToDest(n2));
        // TC: O(n^2)
        // SC: O(n)
    }
}

