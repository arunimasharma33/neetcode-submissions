class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length; //rows
        int m= grid[0].length; //cols
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++){
                if(grid[i][j]=='1'){
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;

    }
    public void bfs(int i, int j, char[][] grid){
        int n=grid.length; //rows
        int m= grid[0].length; //cols
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j]='0';
        int[][] dir={{-1,0}, {1, 0}, {0,1}, {0, -1}}; 
        while(!q.isEmpty()){
            int[] current= q.poll();
            int row= current[0];
            int col= current[1];
            for(int[] d:dir){
                int nrow= row+d[0];
                int ncol= col+d[1];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1'){
                    q.add(new int[]{nrow, ncol});
                    grid[nrow][ncol]='0';
                }
            }
        }
    }
}
