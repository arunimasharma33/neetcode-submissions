
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges (2) to queue, count fresh (1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // include time = 0
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS expansion
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1], time = cell[2];
            minutes = Math.max(minutes, time);

            for (int[] d : dirs) {
                int nr = row + d[0], nc = col + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // fresh becomes rotten
                    fresh--;
                    q.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
