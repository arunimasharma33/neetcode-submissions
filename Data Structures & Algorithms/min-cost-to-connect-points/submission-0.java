class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int cost=0;
        boolean visited[]= new boolean[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> (a[0]- b[0]));
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] current= pq.poll();
            int dist=current[0];
            int node= current[1];
            if(visited[node]==true) continue;
            visited[node]=true;
            cost+=dist;
            for(int j=0; j<n; j++){
                if(!visited[j]){
                    int newDist=Math.abs(points[j][0]-points[node][0])+
                    Math.abs(points[j][1]-points[node][1]);
                    pq.add(new int[]{newDist, j});
                }
            }
        }
        return cost;
    }
    
}
