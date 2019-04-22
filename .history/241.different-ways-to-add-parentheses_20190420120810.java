/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (48.72%)
 * Total Accepted:    71.1K
 * Total Submissions: 143.8K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * 
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * 
 * 
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> curResult = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                String pre = input.substring(0, i);
                String after = input.substring(i);
                List<Integer> preResult = diffWaysToCompute(pre);
                List<Integer> afterResult = diffWaysToCompute(after);
                for(int preRes : preResult) {
                    for(int afterRes : afterResult) {
                            if(cur == '+') {
                                curResult.add(preRes + afterRes);
                            } else if(cur == '-') {
                                curResult.add(preRes - afterRes);
                            } else if(cur == '*') {
                                curResult.add(preRes * afterRes);
                            } else if(cur == '/') {
                                curResult.add(preRes / afterRes);
                            }
                            
                    }
                }
            }
        }
        return curResult;
    }
}

