public class longestPath {
    private int findLongestPath(int[][] path) {
        if(path == null || path.length == 0) return 0;
        int row = path.length;
        int col = path[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] results = new int[row][col];
        int max = 0;
        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 0; j--) {
                for(int[] dir : dirs) {
                    int destX = i + dir[0];
                    int destY = j + dir[1];
                    if(validPoint(destX, destY, row, col) && path[destX][destY] > path[i][j]) {
                        results[i][j] = Math.max(results[i][j], path[destX][destY] - path[i][j]);
                        max = Math.max(results[i][j], max);
                    }                        
                    }
                }
            }
            return max;
        }
        private boolean validPoint(int destX, int destY, int row, int col) {
            return destX >= 0 && destX < row && destY >= 0 && destY < col;
        }
        // 1 2 3 4
        // 5 6 7 8
        public static void main(String[] args) {
            int[][] path = {{1,2,3,4}, {5, 6, 7 ,8}};
            longestPath l = new longestPath();
            int result = l.findLongestPath(path);
            System.out.println(result);
        }
    }