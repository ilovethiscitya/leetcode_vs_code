import org.omg.CosNaming.NameHolder;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (33.44%)
 * Total Accepted:    131.6K
 * Total Submissions: 390.5K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished   
 * course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both     
 * ⁠            courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3] .
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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = buildGraph(numCourses, prerequisites);
        return walkGraph(nodes);
    }
    private Node[] buildGraph(int n, int[][] matrix) {
        Node[] graph = new Node[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new Node(i);
        }
        for(int[] edge : matrix) {
            int parent = edge[1];
            int child = edge[0];
            graph[parent]._childId.add(child);
        }
        return graph;
    }
    private int[] walkGraph(Node[] nodes) {
        int n = nodes.length;
        LinkedList<int[]> resultList = new LinkedList<>();
        boolean[] visitedNode = new boolean[n];
        boolean[] visitedSubGraph = new boolean[n];
        for(int i = 0; i < n; i++) {
            dfs(nodes, i, resultList, visitedNode, visitedSubGraph);
        }
        int[] result = new int[n];
        int idx = 0;
        for(int i : resultList) {
            result[idx++] = i;
        }
        return result;
    }
    private void dfs(Node[] nodes, int i, LinkedList<int[]> resultList, boolean[] visitedNode, boolean[] visitedSubVisted) {
        if(visitedNode[i]) return;
    }
    class Node {
        int _id;
        ArrayList<Integer> _childId = new ArrayList<>();
        public Node(int id) {
            _id = id;
        }
    }
}
