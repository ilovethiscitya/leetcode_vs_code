/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (36.45%)
 * Total Accepted:    202.8K
 * Total Submissions: 543.4K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        buildGraph(graph, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] cycled = new boolean[nunCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, i, visited, cycled)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Node[] graph, int start, boolean[] visited, boolean[] cycled) {
        if(visited[start]) return false;
        if(cycled[start]) return true;
        visited[start] = true;
        for(int child : graph[start].children) {
            if(dfs(graph, child, visited, cycled)) {
                return false;
            }
        }
        visited[start] = false;
        cycled[start] = true;
        return true;
    }
    private void buildGraph(Node[] graph, int[][] prerequisites) {
        
        for(int[] pre : prerequisites) {
            int start = pre[0];
            int end = pre[1];
            if(graph[start] != null) {
                graph[start].children.add(end);
            } else {
                graph[start] = new Node(start);
                graph[start].children.add(end);
            }
        }
    }
    class Node {
        int val;
        ArrayList<Integer> children = new ArrayList<>();
        public Node(int val) {
            this.val = val;
        }
    }
}

