class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;
        List<List<Integer>> result= new ArrayList<>();
        boolean pv[][]= new boolean[n][m];
        boolean av[][]= new boolean[n][m];
        Queue<int[]> pq= new LinkedList<>();
        Queue<int[]> aq= new LinkedList<>();
        for(int i=0; i<n; i++){
            pv[i][0]=true;
            pq.add(new int[]{i, 0});
        }
        for(int i=0; i<m; i++){
            pv[0][i]=true;
            pq.add(new int[]{0, i});
        }
        for(int i=0; i<m ; i++){
            av[n-1][i]=true;
            aq.add(new int[]{n-1, i});
        }
        for(int i=0; i<n; i++){
            av[i][m-1]=true;
            aq.add(new int[]{i, m-1});
        }
        bfs(pv, pq ,heights);
        bfs(av, aq, heights);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if( pv[i][j] && av[i][j] ){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    public void bfs(boolean visited[][], Queue<int[]> q ,int[][] heights){
        int n= heights.length;
        int m= heights[0].length;
        int[][] dir= {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] current=q.poll();
            int row= current[0];
            int col= current[1];
            for(int[] d: dir){
                int nrow= row+d[0];
                int ncol= col+d[1];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]!=true && heights[nrow][ncol]>=heights[row][col]){
                    visited[nrow][ncol]=true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

    }
}
