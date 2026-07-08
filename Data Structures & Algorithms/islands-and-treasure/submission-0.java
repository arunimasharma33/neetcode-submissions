class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        //push all treasues
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i, j});
                }
            }
        }


        int[][] dir= {{-1, 0}, {0,-1}, {0, 1}, {1, 0}};

        while(!q.isEmpty()){
            int[] cell= q.poll();
            int row=cell[0];
            int col= cell[1];
           
            for(int[] val: dir){
                int nrow= row+val[0];
                int ncol=col+val[1];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==Integer.MAX_VALUE){
                    grid[nrow][ncol]=1+grid[row][col];
                    //this is the shortest path
                    q.add(new int[]{nrow, ncol});
                }
            }
            
        }
    }
}
