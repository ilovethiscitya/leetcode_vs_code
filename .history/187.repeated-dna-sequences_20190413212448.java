import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (35.20%)
 * Total Accepted:    121.8K
 * Total Submissions: 341.2K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 
 */
class Solution {
    // public List<String> findRepeatedDnaSequences(String s) {
    //     Set<String> set = new HashSet<>();
    //     List<String> res = new ArrayList<>();
    //     Set<String> duplicate = new HashSet<>();
    //     for(int i = 0; i <= s.length() - 10; i++) {
    //         String sub = s.substring(i, i + 10);
    //         if(!set.add(sub)) {
    //             duplicate.add(sub);
    //         }
    //     }
    //     res.addAll(duplicate);
    //     return res;
    // }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        Set<Integer> firstTime = new HashSet<>();
        Set<Integer> secondTime = new HashSet<>();
        char[] map = new char[26];
        int len = s.length();
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for(int i = 0; i < s.length() - 10; i++) {
            int seq = 0;
            for(int j = i; j < i + 10; j++) {
                seq = seq << 2;
                seq = seq | map[s.charAt(j) - 'A'];
            }
        }
    }
}

