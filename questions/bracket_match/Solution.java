package questions.bracket_match;


/*
Bracket Match
A string of brackets is considered correctly matched if every opening bracket in the string can be
paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched,
whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing
brackets at the end, so you’d return 2.
Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an
input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly
matched.

Explain the correctness of your code, and analyze its time and space complexities.

Examples:
input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2
Constraints:

[time limit] 5000ms
[input] string text
1 ≤ text.length ≤ 5000
[output] integer
*/

import java.io.*;
import java.util.*;

class Solution {

    static int bracketMatch(String text) {
        // your code goes here
        int openCnt = 0, cnt = 0;
        // ())(
        //    ^
        for (int i = 0; i < text.length(); i++) {
            char cur = text.charAt(i);
            if (cur == '(') { //
                openCnt++; // 1 0 1
            } else {
                if (openCnt > 0) {
                    openCnt--; // 1-1 = 0,
                } else {
                    cnt++; // 1
                }
            }
        }
        return cnt + openCnt; // 1 + 1 = 2
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("(()"));
        System.out.println(bracketMatch("(())"));
        System.out.println(bracketMatch("())("));
    }

}


